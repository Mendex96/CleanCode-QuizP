package es.ulpgc.eite.cleancode.quiz.question;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.cleancode.quiz.app.QuestionToCheatState;


public class QuestionPresenter implements QuestionContract.Presenter {

  public static String TAG = QuestionPresenter.class.getSimpleName();

  private WeakReference<QuestionContract.View> view;
  private QuestionViewModel viewModel;
  private QuestionState state;
  private QuestionContract.Model model;
  private QuestionContract.Router router;

  public QuestionPresenter(QuestionState state) {
    this.state = state;
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<QuestionContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(QuestionContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(QuestionContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchQuestionData() {
    //Log.e(TAG, "fetchQuestionData()");

    // set passed state
    CheatToQuestionState newState = router.getDataFromCheatScreen();
    if(newState != null) {

        if(newState.cheated){
          nextButtonClicked();
          return;
        }
    }

    // call the model
    model.setCurrentIndex(state.quizIndex);
    viewModel.questionText = model.getCurrentQuestion();

    view.get().displayQuestionData(viewModel);

  }

  private void updateQuestionData(boolean userAnswer) {

    boolean currentAnswer = model.getCurrentAnswer();

    /*
    if(currentAnswer == userAnswer) {
      viewModel.resultText = view.get().getCorrectLabel();
    } else {
      viewModel.resultText = view.get().getIncorrectLabel();
    }
    */

    if(currentAnswer == userAnswer) {
      viewModel.resultText = model.getCorrectLabel();
    } else {
      viewModel.resultText = model.getIncorrectLabel();
    }

    viewModel.falseButton = false;
    viewModel.trueButton = false;
    viewModel.cheatButton = false;

    if(model.isLastQuestion()) {
      viewModel.nextButton = false;
    } else {
      viewModel.nextButton = true;
    }

    view.get().displayQuestionData(viewModel);
  }


  @Override
  public void trueButtonClicked() {
    updateQuestionData(true);
  }

  @Override
  public void falseButtonClicked() {
    updateQuestionData(false);
  }

  @Override
  public void cheatButtonClicked() {
    boolean answer = model.getCurrentAnswer();
    QuestionToCheatState state = new QuestionToCheatState(answer);
    router.passDataToCheatScreen(state);
    router.navigateToCheatScreen();
  }

  @Override
  public void nextButtonClicked() {
    //Log.e(TAG, "nextButtonClicked()");

    state.quizIndex++;
    model.incrQuizIndex();

    viewModel.questionText = model.getCurrentQuestion();
    viewModel.resultText = "";

    viewModel.falseButton = true;
    viewModel.trueButton = true;
    viewModel.cheatButton = true;
    viewModel.nextButton = false;

    view.get().displayQuestionData(viewModel);
  }

}
