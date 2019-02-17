package es.ulpgc.eite.cleancode.quiz.data;

public interface QuizRepository {

  //String[] getQuestions();
  //boolean[] getAnswers();
  String getQuestion();
  boolean getAnswer();
  void incrIndex();
  boolean isLastIndex();
}
