package es.ulpgc.eite.cleancode.quiz.question;

import java.lang.ref.WeakReference;


public interface QuestionContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayQuestionData(QuestionViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void injectRouter(Router router);

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
    //String getIncorrectLabel();
    //String getCorrectLabel();

    //String getCurrentQuestion(int quizIndex);
    //boolean getCurrentAnswer(int quizIndex);
    //boolean isLastIndex(int quizIndex);


    String getCurrentQuestion();
    boolean getCurrentAnswer();
    boolean isLastQuestion();
    void incrQuizIndex();
    //void checkCurrentAnswer(boolean answer);
    //String getCurrentResult();
    String getCurrentResult(boolean answer);
  }

  interface Router {

    void navigateToCheatScreen();
    void passDataToCheatScreen(boolean answer);
    Boolean getDataFromCheatScreen();
  }
}