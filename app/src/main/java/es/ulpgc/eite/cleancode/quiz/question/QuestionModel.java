package es.ulpgc.eite.cleancode.quiz.question;

import es.ulpgc.eite.cleancode.quiz.app.AppRepository;

public class QuestionModel implements QuestionContract.Model {

  public static String TAG = QuestionModel.class.getSimpleName();


  private AppRepository repository;
  private String correctLabel, incorrectLabel;


  public QuestionModel(AppRepository repository) {
    this.repository = repository;
  }


  @Override
  public String getCorrectLabel() {
    return correctLabel;
  }

  @Override
  public String getIncorrectLabel() {
    return incorrectLabel;
  }

  public void setCorrectLabel(String label) {
    correctLabel = label;
  }

  public void setIncorrectLabel(String label) {
    incorrectLabel = label;
  }

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
