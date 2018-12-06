package es.ulpgc.eite.cleancode.quiz.question;

import android.content.Intent;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;
import es.ulpgc.eite.cleancode.quiz.cheat.CheatActivity;


public class QuestionRouter {

  public static String TAG = QuestionRouter.class.getSimpleName();

  public WeakReference<QuestionActivity> activity;


  public void navigateToCheatScreen() {
    Intent intent = new Intent(activity.get(), CheatActivity.class);
    activity.get().startActivity(intent);
  }

  public void passDataToCheatScreen( boolean answer) {
    AppMediator mediator = (AppMediator) activity.get().getApplication();
    mediator.setAnswer(answer);
  }

  public Boolean getDataFromCheatScreen() {
    AppMediator mediator = (AppMediator) activity.get().getApplication();
    Boolean cheated = mediator.getCheated();
    return cheated;
  }
}
