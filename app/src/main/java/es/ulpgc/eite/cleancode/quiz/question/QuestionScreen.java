package es.ulpgc.eite.cleancode.quiz.question;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.R;
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
    //QuestionContract.Model model = new QuestionModel(repository);

    QuestionModel model = new QuestionModel(repository);
    model.setCorrectLabel(context.get().getString(R.string.correct_label));
    model.setIncorrectLabel(context.get().getString(R.string.incorrect_label));

    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    presenter.injectRouter(router);
    view.injectPresenter(presenter);

  }

}
