package es.ulpgc.eite.cleancode.quiz.app;

import android.app.Application;

import es.ulpgc.eite.cleancode.quiz.cheat.CheatState;
import es.ulpgc.eite.cleancode.quiz.cheat.CheatViewModel;
import es.ulpgc.eite.cleancode.quiz.question.QuestionState;
import es.ulpgc.eite.cleancode.quiz.question.QuestionViewModel;

public class AppMediator extends Application {

  //private QuestionViewModel questionState;
  private QuestionState questionState;
  //private CheatViewModel cheatState;
  private CheatState cheatState;
  private CheatToQuestionState cheatToQuestionState;
  private QuestionToCheatState questionToCheatState;

  //private Boolean answer;
  //private Boolean cheated;

  @Override
  public void onCreate() {
    super.onCreate();

    //questionState = new QuestionViewModel();
    questionState = new QuestionState();
    //cheatState = new CheatViewModel();
    cheatState = new CheatState();
  }

  public CheatState getCheatState() {
    return cheatState;
  }

  public QuestionState getQuestionState() {
    return questionState;
  }

  /*
  public CheatViewModel getCheatState() {
    return cheatState;
  }

  public QuestionViewModel getQuestionState() {
    return questionState;
  }
  */

  public CheatToQuestionState getCheatToQuestionState() {
    CheatToQuestionState state = cheatToQuestionState;
    cheatToQuestionState = null;
    //return cheatToQuestionState;
    return state;
  }

  public void setCheatToQuestionState(CheatToQuestionState state) {
    this.cheatToQuestionState = state;
  }

  public QuestionToCheatState getQuestionToCheatState() {
    QuestionToCheatState state = questionToCheatState;
    questionToCheatState = null;
    //return questionToCheatState;
    return state;
  }

  public void setQuestionToCheatState(QuestionToCheatState state) {
    this.questionToCheatState = state;
  }

  /*
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
  */
}
