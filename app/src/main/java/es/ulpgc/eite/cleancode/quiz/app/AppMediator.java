package es.ulpgc.eite.cleancode.quiz.app;

import android.app.Application;

public class AppMediator extends Application {

  private Boolean answer;
  private Boolean cheated;


  public void setAnswer(Boolean status) {
    answer = status;
  }

  public Boolean getAnswer() {
    Boolean status = answer;
    answer = null;
    return status;
  }

  public void setCheated(Boolean status) {
    cheated = status;
  }

  public Boolean getCheated() {
    Boolean status = cheated;
    cheated = null;
    return status;
  }
}
