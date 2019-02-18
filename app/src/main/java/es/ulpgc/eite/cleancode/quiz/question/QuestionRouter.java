package es.ulpgc.eite.cleancode.quiz.question;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;
import es.ulpgc.eite.cleancode.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.cleancode.quiz.app.QuestionToCheatState;
import es.ulpgc.eite.cleancode.quiz.cheat.CheatActivity;


public class QuestionRouter implements QuestionContract.Router {

  public static String TAG = QuestionRouter.class.getSimpleName();

  //public WeakReference<QuestionActivity> activity;
  //private WeakReference<FragmentActivity> context;
  private AppMediator mediator;

  /*
  public QuestionRouter(WeakReference<FragmentActivity> context) {
    this.context = context;
  }
  */

  public QuestionRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  /*
  @Override
  public void navigateToCheatScreen() {
    Intent intent = new Intent(context.get(), CheatActivity.class);
    context.get().startActivity(intent);
  }
  */

  @Override
  public void navigateToCheatScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, CheatActivity.class);
    context.startActivity(intent);
  }

  /*
  @Override
  public void passDataToCheatScreen( boolean answer) {
    AppMediator mediator = (AppMediator) context.get().getApplication();
    //mediator.setAnswer(answer);
    QuestionToCheatState state = new QuestionToCheatState(answer);
    mediator.setQuestionToCheatState(state);
  }

  @Override
  public Boolean getDataFromCheatScreen() {
    AppMediator mediator = (AppMediator) context.get().getApplication();
    //Boolean cheated = mediator.getCheated();
    //return cheated;
    CheatToQuestionState state = mediator.getCheatToQuestionState();
    if (state != null){
      return state.cheated;
    }

    return null;
  }
  */

  @Override
  public void passDataToCheatScreen(QuestionToCheatState state) {
    //AppMediator mediator = (AppMediator) context.get().getApplication();
    mediator.setQuestionToCheatState(state);
  }

  @Override
  public CheatToQuestionState getDataFromCheatScreen() {
    //AppMediator mediator = (AppMediator) context.get().getApplication();
    return mediator.getCheatToQuestionState();
  }
}
