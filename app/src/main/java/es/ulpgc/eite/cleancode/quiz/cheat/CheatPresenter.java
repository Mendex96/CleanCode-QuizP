package es.ulpgc.eite.cleancode.quiz.cheat;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import java.lang.ref.WeakReference;


public class CheatPresenter implements CheatContract.Presenter {

  public static String TAG = CheatPresenter.class.getSimpleName();

  /*
  public WeakReference<CheatContract.View> view;
  public CheatViewModel viewModel;
  public CheatContract.Model model;
  public CheatRouter router;
  */

  private WeakReference<CheatContract.View> view;
  private CheatViewModel viewModel;
  private CheatContract.Model model;
  private CheatContract.Router router;

  /*
  public CheatPresenter(CheatViewModel viewModel, CheatContract.Router router) {
    this.viewModel = viewModel;
    this.router = router;
  }
  */

  public CheatPresenter(WeakReference<FragmentActivity> context) {
    viewModel = ViewModelProviders
        .of(context.get())
        .get(CheatViewModel.class);
  }

  @Override
  public void injectView(WeakReference<CheatContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CheatContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(CheatContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchCheatData() {
    Log.e(TAG, "fetchCheatData()");

    /*
    // set passed state
    Boolean currentAnswer = router.getDataFromPreviousScreen();
    if(currentAnswer != null) {
        viewModel.answer = currentAnswer;
    }
    */

    // call the model
    viewModel.yesLabel = model.getYesLabel();
    viewModel.noLabel = model.getNoLabel();
    viewModel.confirmationText = model.getConfirmationLabel();

    view.get().displayCheatData(viewModel);

  }

  @Override
  public void yesButtonClicked() {

    /*
    router.passDataToQuestionScreen(true);

    if(viewModel.answer) {
      viewModel.answerText = model.getTrueLabel();
    } else {
      viewModel.answerText = model.getFalseLabel();
    }

    viewModel.yesButton = false;
    viewModel.noButton = false;

    view.get().displayCheatData(viewModel);
    */

    // set passed state
    Boolean answer = router.getDataFromPreviousScreen();
    if(answer != null) {

      router.passDataToQuestionScreen(true);

      if(answer) {
        viewModel.answerText = model.getTrueLabel();
      } else {
        viewModel.answerText = model.getFalseLabel();
      }

      viewModel.yesButton = false;
      viewModel.noButton = false;

      view.get().displayCheatData(viewModel);
    }


  }

  @Override
  public void noButtonClicked() {
    router.passDataToQuestionScreen(false);
    router.navigateToQuestionScreen();
  }


}
