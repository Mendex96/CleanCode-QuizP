package es.ulpgc.eite.cleancode.quiz.question;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;
import es.ulpgc.eite.cleancode.quiz.app.AppRepository;
import es.ulpgc.eite.cleancode.quiz.app.QuizRepository;


public class QuestionScreen {


  public static void configure(QuestionContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    QuestionState state = mediator.getQuestionState();
    AppRepository repository = new QuizRepository();

    QuestionContract.Router router = new QuestionRouter(mediator);
    QuestionContract.Presenter presenter = new QuestionPresenter(state);
    QuestionModel model = new QuestionModel(repository);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    presenter.injectRouter(router);
    view.injectPresenter(presenter);

  }

}
