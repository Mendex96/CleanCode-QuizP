package es.ulpgc.eite.cleancode.quiz.cheat;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.cleancode.quiz.app.QuestionToCheatState;


public class CheatPresenter implements CheatContract.Presenter {

  public static String TAG = CheatPresenter.class.getSimpleName();

  private WeakReference<CheatContract.View> view;
  private CheatViewModel viewModel;
  private CheatContract.Router router;

  public CheatPresenter(CheatState state) {
    this.viewModel = state;
  }

  @Override
  public void injectView(WeakReference<CheatContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CheatContract.Model model) {
    // not implemented
  }

  @Override
  public void injectRouter(CheatContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchCheatData() {
    Log.e(TAG, "fetchCheatData()");

    view.get().displayCheatData(viewModel);

  }

  @Override
  public void yesButtonClicked() {

    // set passed state
    QuestionToCheatState state = router.getDataFromQuestionScreen();
    if(state != null) {

      CheatToQuestionState newState = new CheatToQuestionState(true);
      router.passDataToQuestionScreen(newState);

      if(state.answer) {
        viewModel.answerText = view.get().getTrueLabel();
      } else {
        viewModel.answerText = view.get().getFalseLabel();
      }

      viewModel.yesButton = false;
      viewModel.noButton = false;

      view.get().displayCheatData(viewModel);
    }
  }

  @Override
  public void noButtonClicked() {
    CheatToQuestionState newState = new CheatToQuestionState(false);
    router.passDataToQuestionScreen(newState);
    view.get().finishView();
  }


}
