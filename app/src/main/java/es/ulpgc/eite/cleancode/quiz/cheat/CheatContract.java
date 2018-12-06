package es.ulpgc.eite.cleancode.quiz.cheat;

interface CheatContract {

  interface View {
    void displayCheatData(CheatViewModel viewModel);
  }

  interface Presenter {
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
}