package es.ulpgc.eite.cleancode.quiz.cheat;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;
import es.ulpgc.eite.cleancode.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.cleancode.quiz.app.QuestionToCheatState;


public class CheatRouter implements CheatContract.Router {

  public static String TAG = CheatRouter.class.getSimpleName();

  //public WeakReference<CheatActivity> activity;
  //private WeakReference<FragmentActivity> context;
  private AppMediator mediator;

  /*
  public CheatRouter(WeakReference<FragmentActivity> context) {
    this.context = context;
  }
  */

  public CheatRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  /*
  @Override
  public void navigateToQuestionScreen() {
    //Context context = mediator.getApplicationContext();
    //context.finish();
    context.get().finish();
  }
  */

  /*
  @Override
  public void navigateToNextScreen() {
    Intent intent = new Intent(context.get(), CheatActivity.class);
    context.get().startActivity(intent);
  }
  */

  /*
  @Override
  public void passDataToQuestionScreen(Boolean cheated) {
    AppMediator mediator = (AppMediator) context.get().getApplication();
    //mediator.setCheated(cheated);
    CheatToQuestionState state = new CheatToQuestionState(cheated);
    mediator.setCheatToQuestionState(state);
  }

  @Override
  public Boolean getDataFromQuestionScreen() {
    AppMediator mediator = (AppMediator) context.get().getApplication();
    //Boolean answer = mediator.getAnswer();
    //return answer;
    QuestionToCheatState state = mediator.getQuestionToCheatState();
    if(state != null) {
      return state.answer;
    }

    return null;
  }
  */

  @Override
  public void passDataToQuestionScreen(CheatToQuestionState state) {
    //AppMediator mediator = (AppMediator) context.get().getApplication();
    mediator.setCheatToQuestionState(state);
  }

  @Override
  public QuestionToCheatState getDataFromQuestionScreen() {
    //AppMediator mediator = (AppMediator) context.get().getApplication();
    return mediator.getQuestionToCheatState();
  }
}
