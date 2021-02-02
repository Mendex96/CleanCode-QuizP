package es.ulpgc.eite.cleancode.quiz.question;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;
import es.ulpgc.eite.cleancode.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.cleancode.quiz.app.QuestionToCheatState;


public class QuestionRouter implements QuestionContract.Router {

  public static String TAG = QuestionRouter.class.getSimpleName();

  private AppMediator mediator;

  public QuestionRouter(AppMediator mediator) {
    this.mediator = mediator;
  }


  @Override
  public void passDataToCheatScreen(QuestionToCheatState state) {
    mediator.setQuestionToCheatState(state);
  }

  @Override
  public CheatToQuestionState getDataFromCheatScreen() {
    return mediator.getCheatToQuestionState();
  }
}
