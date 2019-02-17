package es.ulpgc.eite.cleancode.quiz.question;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import java.lang.ref.WeakReference;


public class QuestionPresenter implements QuestionContract.Presenter {

  public static String TAG = QuestionPresenter.class.getSimpleName();

  private WeakReference<QuestionContract.View> view;
  private QuestionViewModel viewModel;
  private QuestionContract.Model model;
  private QuestionContract.Router router;

  /*
  public WeakReference<QuestionContract.View> view;
  public QuestionViewModel viewModel;
  public QuestionContract.Model model;
  public QuestionRouter router;
  */

  /*
  public QuestionPresenter(
      QuestionViewModel viewModel, QuestionContract.Router router) {

    this.viewModel = viewModel;
    this.router = router;
  }
  */

  public QuestionPresenter(WeakReference<FragmentActivity> context) {
    viewModel = ViewModelProviders
        .of(context.get())
        .get(QuestionViewModel.class);
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
    //viewModel.questionText = model.getCurrentQuestion(viewModel.quizIndex);
    viewModel.questionText = model.getCurrentQuestion();

    view.get().displayQuestionData(viewModel);

  }

  private void updateQuestionData(boolean userAnswer) {
    /*
    //boolean currentAnswer = model.getCurrentAnswer(viewModel.quizIndex);
    boolean currentAnswer = model.getCurrentAnswer();

    if(currentAnswer == userAnswer) {
      viewModel.resultText = model.getCorrectLabel();
    } else {
      viewModel.resultText = model.getIncorrectLabel();
    }
    */

    //model.checkCurrentAnswer(userAnswer);
    //viewModel.resultText = model.getCurrentResult();
    viewModel.resultText = model.getCurrentResult(userAnswer);

    viewModel.falseButton = false;
    viewModel.trueButton = false;
    viewModel.cheatButton = false;

    /*
    if(model.isQuizFinished(viewModel.quizIndex)) {
      viewModel.nextButton = false;
    } else {
      viewModel.nextButton = true;
    }
    */

    if(model.isQuizFinished()) {
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
    //boolean answer = model.getCurrentAnswer(viewModel.quizIndex);
    boolean answer = model.getCurrentAnswer();
    router.passDataToCheatScreen(answer);
    router.navigateToCheatScreen();
  }

  @Override
  public void nextButtonClicked() {
    Log.e(TAG, "nextButtonClicked()");

    //viewModel.quizIndex++;
    model.incrQuizIndex();

    //viewModel.questionText = model.getCurrentQuestion(viewModel.quizIndex);
    viewModel.questionText = model.getCurrentQuestion();
    viewModel.resultText = "";

    viewModel.falseButton = true;
    viewModel.trueButton = true;
    viewModel.cheatButton = true;
    viewModel.nextButton = false;

    view.get().displayQuestionData(viewModel);
  }


}
