package es.ulpgc.eite.cleancode.quiz.cheat;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.cleancode.quiz.app.QuestionToCheatState;


public class CheatPresenter implements CheatContract.Presenter {

  public static String TAG = CheatPresenter.class.getSimpleName();

  /*
  public WeakReference<CheatContract.View> view;
  public CheatViewModel viewModel;
  public CheatContract.Model model;
  public CheatRouter router;
  */

  private WeakReference<CheatContract.View> view;
  private CheatViewModel viewModel;
  //private CheatState state;
  //private CheatContract.Model model;
  private CheatContract.Router router;

  /*
  public CheatPresenter(CheatViewModel viewModel) {
    this.viewModel = viewModel;
  }
  */

  public CheatPresenter(CheatState state) {
    //this.state = state;
    this.viewModel = state;
  }

  /*
  public CheatPresenter(CheatViewModel viewModel, CheatContract.Router router) {
    this.viewModel = viewModel;
    this.router = router;
  }
  */

  /*
  public CheatPresenter(WeakReference<FragmentActivity> context) {
    viewModel = ViewModelProviders
        .of(context.get())
        .get(CheatViewModel.class);
  }
  */

  @Override
  public void injectView(WeakReference<CheatContract.View> view) {
    this.view = view;
  }

  /*
  @Override
  public void injectModel(CheatContract.Model model) {
    this.model = model;
  }
  */

  @Override
  public void injectModel(CheatContract.Model model) {
    // not implemented
  }

  @Override
  public void injectRouter(CheatContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchCheatData() {
    Log.e(TAG, "fetchCheatData()");

    /*
    // set passed state
    Boolean currentAnswer = router.getDataFromQuestionScreen();
    if(currentAnswer != null) {
        viewModel.answer = currentAnswer;
    }
    */

    /*
    // call the model
    viewModel.yesLabel = model.getYesLabel();
    viewModel.noLabel = model.getNoLabel();
    viewModel.confirmationText = model.getConfirmationLabel();
    */

    view.get().displayCheatData(viewModel);

  }

  @Override
  public void yesButtonClicked() {

    /*
    router.passDataToQuestionScreen(true);

    if(viewModel.answer) {
      viewModel.answerText = model.getTrueLabel();
    } else {
      viewModel.answerText = model.getFalseLabel();
    }

    viewModel.yesButton = false;
    viewModel.noButton = false;

    view.get().displayCheatData(viewModel);
    */

    // set passed state
    QuestionToCheatState state = router.getDataFromQuestionScreen();
    if(state != null) {

      //router.passDataToQuestionScreen(true);
      CheatToQuestionState newState = new CheatToQuestionState(true);
      router.passDataToQuestionScreen(newState);

      /*
      if(answer) {
        viewModel.answerText = model.getTrueLabel();
      } else {
        viewModel.answerText = model.getFalseLabel();
      }
      */

      //viewModel.answerText = model.getAnswerLabel(answer);

      if(state.answer) {
        viewModel.answerText = view.get().getTrueLabel();
      } else {
        viewModel.answerText = view.get().getFalseLabel();
      }

      viewModel.yesButton = false;
      viewModel.noButton = false;

      view.get().displayCheatData(viewModel);
    }

//    Boolean answer = router.getDataFromQuestionScreen();
//    if(answer != null) {
//
//      router.passDataToQuestionScreen(true);
//
//      /*
//      if(answer) {
//        viewModel.answerText = model.getTrueLabel();
//      } else {
//        viewModel.answerText = model.getFalseLabel();
//      }
//      */
//
//      //viewModel.answerText = model.getAnswerLabel(answer);
//
//      if(answer) {
//        viewModel.answerText = view.get().getTrueLabel();
//      } else {
//        viewModel.answerText = view.get().getFalseLabel();
//      }
//
//      viewModel.yesButton = false;
//      viewModel.noButton = false;
//
//      view.get().displayCheatData(viewModel);
//    }


  }

  @Override
  public void noButtonClicked() {
    //router.passDataToQuestionScreen(false);
    CheatToQuestionState newState = new CheatToQuestionState(false);
    router.passDataToQuestionScreen(newState);
    //router.navigateToQuestionScreen();
    view.get().finishView();
  }


}
