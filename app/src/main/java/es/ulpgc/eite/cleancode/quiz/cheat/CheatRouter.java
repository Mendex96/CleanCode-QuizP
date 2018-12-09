package es.ulpgc.eite.cleancode.quiz.cheat;

import android.content.Intent;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;


public class CheatRouter {

  public static String TAG = CheatRouter.class.getSimpleName();

  public WeakReference<CheatActivity> activity;


  public void navigateToQuestionScreen() {
    activity.get().finish();
  }

  public void navigateToNextScreen() {
    Intent intent = new Intent(activity.get(), CheatActivity.class);
    activity.get().startActivity(intent);
  }

  public void passDataToQuestionScreen(Boolean cheated) {
    AppMediator mediator = (AppMediator) activity.get().getApplication();
    mediator.setCheated(cheated);
  }

  public Boolean getDataFromPreviousScreen() {
    AppMediator mediator = (AppMediator) activity.get().getApplication();
    Boolean answer = mediator.getAnswer();
    return answer;
  }
}
