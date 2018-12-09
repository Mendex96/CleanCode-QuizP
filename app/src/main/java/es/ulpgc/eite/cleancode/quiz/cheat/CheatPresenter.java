package es.ulpgc.eite.cleancode.quiz.cheat;

import android.util.Log;

import java.lang.ref.WeakReference;


public class CheatPresenter implements CheatContract.Presenter {

  public static String TAG = CheatPresenter.class.getSimpleName();

  public WeakReference<CheatContract.View> view;
  public CheatViewModel viewModel;
  public CheatContract.Model model;
  public CheatRouter router;

  @Override
  public void fetchCheatData() {
    Log.e(TAG, "fetchCheatData()");

    // set passed state
    Boolean currentAnswer = router.getDataFromPreviousScreen();
    if(currentAnswer != null) {
        viewModel.answer = currentAnswer;
    }

    // call the model
    viewModel.yesLabel = model.getYesLabel();
    viewModel.noLabel = model.getNoLabel();
    viewModel.confirmationText = model.getConfirmationLabel();

    view.get().displayCheatData(viewModel);

  }

  @Override
  public void yesButtonClicked() {
    router.passDataToQuestionScreen(viewModel.answer);

    if(viewModel.answer) {
      viewModel.cheatText = model.getTrueLabel();
    } else {
      viewModel.cheatText = model.getFalseLabel();
    }

    viewModel.yesButton = false;
    viewModel.noButton = false;

    view.get().displayCheatData(viewModel);
  }

  @Override
  public void noButtonClicked() {
    router.navigateToQuestionScreen();
  }


}
