package es.ulpgc.eite.cleancode.quiz.question;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.cleancode.quiz.app.QuestionToCheatState;
import es.ulpgc.eite.cleancode.quiz.question.mocks.MockQuestionActivity;


public interface QuestionContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayQuestionData(QuestionViewModel viewModel);
    String getIncorrectLabel();
    String getCorrectLabel();
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
    //String getIncorrectLabel();
    //String getCorrectLabel();

    /*
    String getTrueLabel();
    String getCheatLabel();
    String getNextLabel();
    String getFalseLabel();
    */

    //String getCurrentQuestion(int quizIndex);
    //boolean getCurrentAnswer(int quizIndex);
    //boolean isLastIndex(int quizIndex);


    String getCurrentQuestion();
    boolean getCurrentAnswer();
    boolean isLastQuestion();
    void incrQuizIndex();
    void setCurrentIndex(int index);
    //void checkCurrentAnswer(boolean answer);
    //String getCurrentResult();
    //String getCurrentResult(boolean answer);
  }

  interface Router {

    void navigateToCheatScreen();
    //void passDataToCheatScreen(boolean answer);
    void passDataToCheatScreen(QuestionToCheatState state);
    CheatToQuestionState getDataFromCheatScreen();
    //Boolean getDataFromCheatScreen();
  }
}