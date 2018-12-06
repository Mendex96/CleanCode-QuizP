package es.ulpgc.eite.cleancode.quiz.question;

import android.arch.lifecycle.ViewModel;

// include this library dependency in build.gradle file
// implementation 'android.arch.lifecycle:extensions:1.1.1'
public class QuestionViewModel extends ViewModel {

  public String falseLabel;
  public String trueLabel;
  public String cheatLabel;
  public String nextLabel;

  public String questionText;
  public String answerText = "";

  public boolean falseButton = true;
  public boolean trueButton = true;
  public boolean cheatButton = true;
  public boolean nextButton = false;

  public Boolean answerCheated = false;
  public int quizIndex = 0;
}

