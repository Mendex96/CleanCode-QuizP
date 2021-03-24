package es.ulpgc.eite.cleancode.quiz.cheat;

import java.lang.ref.WeakReference;


public interface CheatContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayCheatData(CheatViewModel viewModel);
    void finishView();
    String getFalseLabel();
    String getTrueLabel();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void onCreateCalled();
    void yesButtonClicked();
    void noButtonClicked();

    void onResumeCalled();
  }

}