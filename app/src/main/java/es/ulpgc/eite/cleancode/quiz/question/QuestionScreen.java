package es.ulpgc.eite.cleancode.quiz.question;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;
import es.ulpgc.eite.cleancode.quiz.app.AppRepository;
import es.ulpgc.eite.cleancode.quiz.app.QuizRepository;


public class QuestionScreen {


  public static void configure(QuestionContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AppRepository repository = new QuizRepository();
    QuestionState state = mediator.getQuestionState();

    /*
    QuestionViewModel viewModel =
        ViewModelProviders.of(context.get()).get(QuestionViewModel.class);
    */

    //QuestionContract.Router router = new QuestionRouter(context);
    QuestionContract.Router router = new QuestionRouter(mediator);
    /*
    QuestionContract.Presenter presenter =
        new QuestionPresenter(viewModel, router);
    */
    QuestionContract.Presenter presenter = new QuestionPresenter(state);
    //QuestionContract.Presenter presenter = new QuestionPresenter(context);
    //QuestionModel model = new QuestionModel(context);
    QuestionModel model = new QuestionModel(repository);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    presenter.injectRouter(router);
    view.injectPresenter(presenter);

  }

}
