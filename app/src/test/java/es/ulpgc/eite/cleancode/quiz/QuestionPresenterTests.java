package es.ulpgc.eite.cleancode.quiz;

import org.junit.Test;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.AppRepository;
import es.ulpgc.eite.cleancode.quiz.app.QuizRepository;
import es.ulpgc.eite.cleancode.quiz.question.QuestionContract;
import es.ulpgc.eite.cleancode.quiz.question.QuestionModel;
import es.ulpgc.eite.cleancode.quiz.question.QuestionPresenter;
import es.ulpgc.eite.cleancode.quiz.question.QuestionState;
import es.ulpgc.eite.cleancode.quiz.question.mocks.MockQuestionActivity;
import es.ulpgc.eite.cleancode.quiz.question.mocks.MockQuestionRouter;

import static org.junit.Assert.assertEquals;

public class QuestionPresenterTests {

  @Test
  public void testNoClickAnyButton() {

    // Given
    QuestionState state = new QuestionState();
    AppRepository repository = new QuizRepository();
    QuestionContract.Presenter presenter = new QuestionPresenter(state);
    MockQuestionActivity activity = new MockQuestionActivity();
    QuestionContract.View view = activity;
    QuestionContract.Model model = new QuestionModel(repository);
    QuestionContract.Router router = new MockQuestionRouter();
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    presenter.injectRouter(router);
    activity.injectPresenter(presenter);

    // When
    presenter.fetchQuestionData();
    String question1 = activity.getQuestion();
    String question2 = model.getCurrentQuestion();
    String result = activity.getResult();

    // Then
    assertEquals("Get current question failed", question1, question2);
    assertEquals("Get current result failed", result, "");
  }
}
