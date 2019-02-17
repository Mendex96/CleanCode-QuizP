package es.ulpgc.eite.cleancode.quiz.question;

import java.lang.ref.WeakReference;

import android.content.Context;
import android.support.v4.app.FragmentActivity;


public class QuestionScreen {


  public static void configure(QuestionContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    /*
    QuestionViewModel viewModel =
        ViewModelProviders.of(context.get()).get(QuestionViewModel.class);
    */

    QuestionContract.Router router = new QuestionRouter(context);
    /*
    QuestionContract.Presenter presenter =
        new QuestionPresenter(viewModel, router);
    */
    QuestionContract.Presenter presenter = new QuestionPresenter(context);
    QuestionModel model = new QuestionModel(context);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    presenter.injectRouter(router);
    view.injectPresenter(presenter);

  }

}
