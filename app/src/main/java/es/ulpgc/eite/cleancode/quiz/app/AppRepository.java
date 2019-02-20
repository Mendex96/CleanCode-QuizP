package es.ulpgc.eite.cleancode.quiz.app;

public interface AppRepository {

  String getQuestion();
  boolean getAnswer();
  void incrIndex();
  boolean isLastIndex();
  void setIndex(int index);
}
