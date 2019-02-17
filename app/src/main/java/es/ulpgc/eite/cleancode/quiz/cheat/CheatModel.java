package es.ulpgc.eite.cleancode.quiz.cheat;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.R;

public class CheatModel implements CheatContract.Model {

  public static String TAG = CheatModel.class.getSimpleName();

  /*
  private String yesLabel = "Yes";
  private String noLabel = "No";
  private String confirmationLabel = "Are you sure?";
  private String falseLabel = "False";
  private String trueLabel = "True";
  */

  //private WeakReference<CheatActivity> activity;
  private WeakReference<FragmentActivity> context;

  /*
  public CheatModel(WeakReference<CheatActivity> activity) {
    this.activity = activity;
  }
  */

  public CheatModel(WeakReference<FragmentActivity> context) {
    this.context = context;
  }

  @Override
  public String getYesLabel() {
    //return yesLabel;
    return context.get()
        .getResources().getString(R.string.yes_label);
  }

  @Override
  public String getNoLabel() {
    //return noLabel;
    return context.get()
        .getResources().getString(R.string.no_label);
  }

  @Override
  public String getConfirmationLabel() {
    //return confirmationLabel;
    return context.get()
        .getResources().getString(R.string.confirmation_label);
  }

  @Override
  public String getAnswerLabel(Boolean answer) {
    if(answer) {
      return getTrueLabel();
    } else {
      return getFalseLabel();
    }
  }

  private String getFalseLabel() {
    //return falseLabel;
    return context.get()
        .getResources().getString(R.string.false_label);
  }


  private String getTrueLabel() {
    //return trueLabel;
    return context.get()
        .getResources().getString(R.string.true_label);
  }
}
