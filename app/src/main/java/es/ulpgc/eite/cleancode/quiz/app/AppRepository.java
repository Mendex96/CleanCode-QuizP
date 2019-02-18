package es.ulpgc.eite.cleancode.quiz.app;

public interface AppRepository {

  //String[] getQuestions();
  //boolean[] getAnswers();
  String getQuestion();
  boolean getAnswer();
  void incrIndex();
  boolean isLastIndex();
  void setIndex(int index);
}
