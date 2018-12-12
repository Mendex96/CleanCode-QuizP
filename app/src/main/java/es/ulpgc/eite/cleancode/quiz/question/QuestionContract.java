package es.ulpgc.eite.cleancode.quiz.question;

import java.lang.ref.WeakReference;


interface QuestionContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayQuestionData(QuestionViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);

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

  interface Router {

    void navigateToCheatScreen();
    void passDataToCheatScreen(boolean answer);
    Boolean getDataFromCheatScreen();
  }
}