package es.ulpgc.eite.cleancode.quiz.cheat;

import java.lang.ref.WeakReference;


interface CheatContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayCheatData(CheatViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void injectRouter(Router router);

    void fetchCheatData();
    void yesButtonClicked();
    void noButtonClicked();
  }

  interface Model {
    String getYesLabel();
    String getNoLabel();
    String getConfirmationLabel();
    String getFalseLabel();
    String getTrueLabel();
  }

  interface Router {

    void navigateToQuestionScreen();
    void navigateToNextScreen();
    void passDataToQuestionScreen(Boolean cheated);
    Boolean getDataFromPreviousScreen();
  }
}