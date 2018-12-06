package es.ulpgc.eite.cleancode.quiz.cheat;

import android.util.Log;

import java.lang.ref.WeakReference;

public class CheatModel implements CheatContract.Model {

  public static String TAG = CheatModel.class.getSimpleName();

  private String yesLabel = "Yes";
  private String noLabel = "No";
  private String confirmationLabel = "Are you sure?";
  private String falseLabel = "False";
  private String trueLabel = "True";

  private WeakReference<CheatActivity> activity;

  public CheatModel(WeakReference<CheatActivity> activity) {
    this.activity = activity;
  }

  @Override
  public String getYesLabel() {
    return yesLabel;
  }

  @Override
  public String getNoLabel() {
    return noLabel;
  }

  @Override
  public String getConfirmationLabel() {
    return confirmationLabel;
  }

  @Override
  public String getFalseLabel() {
    return falseLabel;
  }


  @Override
  public String getTrueLabel() {
    return trueLabel;
  }
}
