package es.ulpgc.eite.cleancode.quiz.question;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;
import es.ulpgc.eite.cleancode.quiz.cheat.CheatActivity;


public class QuestionRouter implements QuestionContract.Router {

  public static String TAG = QuestionRouter.class.getSimpleName();

  //public WeakReference<QuestionActivity> activity;
  private WeakReference<FragmentActivity> context;

  public QuestionRouter(WeakReference<FragmentActivity> context) {
    this.context = context;
  }

  @Override
  public void navigateToCheatScreen() {
    Intent intent = new Intent(context.get(), CheatActivity.class);
    context.get().startActivity(intent);
  }

  @Override
  public void passDataToCheatScreen( boolean answer) {
    AppMediator mediator = (AppMediator) context.get().getApplication();
    mediator.setAnswer(answer);
  }

  @Override
  public Boolean getDataFromCheatScreen() {
    AppMediator mediator = (AppMediator) context.get().getApplication();
    Boolean cheated = mediator.getCheated();
    return cheated;
  }
}
