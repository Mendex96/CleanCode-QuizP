package es.ulpgc.eite.cleancode.quiz.cheat;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;
import es.ulpgc.eite.cleancode.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.cleancode.quiz.app.QuestionToCheatState;


public class CheatPresenter implements CheatContract.Presenter {

  public static String TAG = CheatPresenter.class.getSimpleName();

  private WeakReference<CheatContract.View> view;
  private CheatState state;
  //private CheatContract.Router router;
  private AppMediator mediator;

  public CheatPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getCheatState();
  }

  /*
  public CheatPresenter(CheatState state) {
    this.state = state;
  }
  */

  @Override
  public void injectView(WeakReference<CheatContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CheatContract.Model model) {
    // not implemented
  }

  /*
  @Override
  public void injectRouter(CheatContract.Router router) {
    this.router = router;
  }
  */

  @Override
  public void onCreateCalled() {
    Log.e(TAG, "onCreateCalled()");

    view.get().displayCheatData(state);

  }

  @Override
  public void yesButtonClicked() {

    // set passed state
    QuestionToCheatState savedState = getDataFromQuestionScreen();
    //QuestionToCheatState savedState = router.getDataFromQuestionScreen();
    if(savedState != null) {

      CheatToQuestionState newState = new CheatToQuestionState(true);
      //router.passDataToQuestionScreen(newState);
      passDataToQuestionScreen(newState);

      if(savedState.answer) {
        state.answerText = view.get().getTrueLabel();
      } else {
        state.answerText = view.get().getFalseLabel();
      }

      state.yesButton = false;
      state.noButton = false;

      view.get().displayCheatData(state);
    }
  }

  @Override
  public void noButtonClicked() {
    CheatToQuestionState newState = new CheatToQuestionState(false);
    //router.passDataToQuestionScreen(newState);
    passDataToQuestionScreen(newState);
    view.get().finishView();
  }

  private void passDataToQuestionScreen(CheatToQuestionState state) {
    mediator.setCheatToQuestionState(state);
  }

  private QuestionToCheatState getDataFromQuestionScreen() {
    return mediator.getQuestionToCheatState();
  }

}
