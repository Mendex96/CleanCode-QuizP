package es.ulpgc.eite.cleancode.quiz.cheat;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;


public class CheatRouter implements CheatContract.Router {

  public static String TAG = CheatRouter.class.getSimpleName();

  //public WeakReference<CheatActivity> activity;
  private WeakReference<FragmentActivity> activity;

  public CheatRouter(WeakReference<FragmentActivity> activity) {
    this.activity = activity;
  }


  @Override
  public void navigateToQuestionScreen() {
    activity.get().finish();
  }

  @Override
  public void navigateToNextScreen() {
    Intent intent = new Intent(activity.get(), CheatActivity.class);
    activity.get().startActivity(intent);
  }

  @Override
  public void passDataToQuestionScreen(Boolean cheated) {
    AppMediator mediator = (AppMediator) activity.get().getApplication();
    mediator.setCheated(cheated);
  }

  @Override
  public Boolean getDataFromPreviousScreen() {
    AppMediator mediator = (AppMediator) activity.get().getApplication();
    Boolean answer = mediator.getAnswer();
    return answer;
  }
}
