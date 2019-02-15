package es.ulpgc.eite.cleancode.quiz.cheat;

import android.arch.lifecycle.ViewModel;

// include this library dependency in build.gradle file
// implementation 'android.arch.lifecycle:extensions:1.1.1'
public class CheatViewModel extends ViewModel {

  public String answerText = "";
  public String confirmationText;
  public String yesLabel;
  public String noLabel;

  public boolean yesButton = true;
  public boolean noButton = true;

  //public boolean answer;

}

