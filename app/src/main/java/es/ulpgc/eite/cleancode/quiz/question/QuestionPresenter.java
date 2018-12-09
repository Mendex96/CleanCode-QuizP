package es.ulpgc.eite.cleancode.quiz.question;

import android.util.Log;

import java.lang.ref.WeakReference;


public class QuestionPresenter implements QuestionContract.Presenter {

  public static String TAG = QuestionPresenter.class.getSimpleName();

  public WeakReference<QuestionContract.View> view;
  public QuestionViewModel viewModel;
  public QuestionContract.Model model;
  public QuestionRouter router;

  @Override
  public void fetchQuestionData() {
    Log.e(TAG, "fetchQuestionData()");

    // set passed state
    Boolean cheated = router.getDataFromCheatScreen();
    if(cheated != null) {
        //viewModel.answerCheated = cheated;
        //nextButtonClicked();
        //return;

        if(cheated){
          nextButtonClicked();
          return;
        }
    }

    // call the model
    viewModel.trueLabel = model.getTrueLabel();
    viewModel.falseLabel = model.getFalseLabel();
    viewModel.cheatLabel = model.getCheatLabel();
    viewModel.nextLabel = model.getNextLabel();
    viewModel.questionText = model.getCurrentQuestion(viewModel.quizIndex);

    view.get().displayQuestionData(viewModel);

  }

  private void updateQuestionData(boolean userAnswer) {
    boolean currentAnswer = model.getCurrentAnswer(viewModel.quizIndex);

    if(currentAnswer == userAnswer) {
      viewModel.answerText = model.getCorrectLabel();
    } else {
      viewModel.answerText = model.getIncorrectLabel();
    }

    viewModel.falseButton = false;
    viewModel.trueButton = false;
    viewModel.cheatButton = false;

    if(model.isQuizFinished(viewModel.quizIndex)) {
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
    boolean answer = model.getCurrentAnswer(viewModel.quizIndex);
    router.passDataToCheatScreen(answer);
    router.navigateToCheatScreen();
  }

  @Override
  public void nextButtonClicked() {
    Log.e(TAG, "nextButtonClicked()");

    viewModel.quizIndex++;

    viewModel.questionText = model.getCurrentQuestion(viewModel.quizIndex);
    viewModel.answerText = "";

    viewModel.falseButton = true;
    viewModel.trueButton = true;
    viewModel.cheatButton = true;
    viewModel.nextButton = false;

    view.get().displayQuestionData(viewModel);
  }


}
