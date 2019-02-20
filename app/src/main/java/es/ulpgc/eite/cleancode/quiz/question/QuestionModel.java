package es.ulpgc.eite.cleancode.quiz.question;

import es.ulpgc.eite.cleancode.quiz.app.AppRepository;

public class QuestionModel implements QuestionContract.Model {

  public static String TAG = QuestionModel.class.getSimpleName();

  private AppRepository repository;

  public QuestionModel(AppRepository repository) {
    this.repository = repository;
  }

  /*
  @Override
  public String getCheatLabel() {
    return context.get()
        .getResources().getString(R.string.cheat_label);
  }

  @Override
  public String getNextLabel() {
    return context.get()
        .getResources().getString(R.string.next_label);
  }

  @Override
  public String getFalseLabel() {
    return context.get()
        .getResources().getString(R.string.false_label);
  }


  private String getIncorrectLabel() {
    return context.get()
        .getResources().getString(R.string.incorrect_label);
  }

  private String getCorrectLabel() {
    return context.get()
        .getResources().getString(R.string.correct_label);
  }

  @Override
  public String getTrueLabel() {
    return context.get()
        .getResources().getString(R.string.true_label);
  }
  */

  @Override
  public String getCurrentQuestion() {
    return repository.getQuestion();
  }

  @Override
  public boolean getCurrentAnswer() {
    return repository.getAnswer();
  }

  @Override
  public boolean isLastQuestion() {
    return repository.isLastIndex();
  }

  @Override
  public void incrQuizIndex() {
    repository.incrIndex();
  }

  @Override
  public void setCurrentIndex(int index) {
    repository.setIndex(index);
  }

}
