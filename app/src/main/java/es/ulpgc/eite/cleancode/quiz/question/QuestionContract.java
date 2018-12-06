package es.ulpgc.eite.cleancode.quiz.question;

interface QuestionContract {

  interface View {
    void displayQuestionData(QuestionViewModel viewModel);
  }

  interface Presenter {
    void fetchQuestionData();
    void trueButtonClicked();
    void falseButtonClicked();
    void cheatButtonClicked();
    void nextButtonClicked();
  }

  interface Model {
    String getTrueLabel();
    String getCheatLabel();
    String getNextLabel();
    String getFalseLabel();
    String getIncorrectLabel();
    String getCorrectLabel();

    String getCurrentQuestion(int quizIndex);
    boolean getCurrentAnswer(int quizIndex);
    boolean isQuizFinished(int quizIndex);

  }
}