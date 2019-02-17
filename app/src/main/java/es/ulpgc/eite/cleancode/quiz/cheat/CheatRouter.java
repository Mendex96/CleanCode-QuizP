package es.ulpgc.eite.cleancode.quiz.cheat;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;


public class CheatRouter implements CheatContract.Router {

  public static String TAG = CheatRouter.class.getSimpleName();

  //public WeakReference<CheatActivity> activity;
  private WeakReference<FragmentActivity> context;

  public CheatRouter(WeakReference<FragmentActivity> context) {
    this.context = context;
  }


  @Override
  public void navigateToQuestionScreen() {
    context.get().finish();
  }

  /*
  @Override
  public void navigateToNextScreen() {
    Intent intent = new Intent(context.get(), CheatActivity.class);
    context.get().startActivity(intent);
  }
  */

  @Override
  public void passDataToQuestionScreen(Boolean cheated) {
    AppMediator mediator = (AppMediator) context.get().getApplication();
    mediator.setCheated(cheated);
  }

  @Override
  public Boolean getDataFromPreviousScreen() {
    AppMediator mediator = (AppMediator) context.get().getApplication();
    Boolean answer = mediator.getAnswer();
    return answer;
  }
}
