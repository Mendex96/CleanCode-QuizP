package es.ulpgc.eite.cleancode.quiz.question;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;
import es.ulpgc.eite.cleancode.quiz.cheat.CheatActivity;


public class QuestionRouter implements QuestionContract.Router {

  public static String TAG = QuestionRouter.class.getSimpleName();

  //public WeakReference<QuestionActivity> activity;
  private WeakReference<FragmentActivity> activity;

  public QuestionRouter(WeakReference<FragmentActivity> activity) {
    this.activity = activity;
  }

  @Override
  public void navigateToCheatScreen() {
    Intent intent = new Intent(activity.get(), CheatActivity.class);
    activity.get().startActivity(intent);
  }

  @Override
  public void passDataToCheatScreen( boolean answer) {
    AppMediator mediator = (AppMediator) activity.get().getApplication();
    mediator.setAnswer(answer);
  }

  @Override
  public Boolean getDataFromCheatScreen() {
    AppMediator mediator = (AppMediator) activity.get().getApplication();
    Boolean cheated = mediator.getCheated();
    return cheated;
  }
}
