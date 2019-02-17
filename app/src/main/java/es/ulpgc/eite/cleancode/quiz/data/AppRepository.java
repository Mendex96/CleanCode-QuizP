package es.ulpgc.eite.cleancode.quiz.data;

public interface AppRepository {

  String[] getQuestions();
  boolean[] getAnswers();
}
