package es.ulpgc.eite.cleancode.quiz.question;

import java.lang.ref.WeakReference;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;


public class QuestionScreen {


  public static void configure(QuestionContract.View view) {

    WeakReference<FragmentActivity> activity =
        new WeakReference<>((FragmentActivity) view);

    QuestionViewModel viewModel =
        ViewModelProviders.of(activity.get()).get(QuestionViewModel.class);

    QuestionContract.Router router = new QuestionRouter(activity);
    QuestionContract.Presenter presenter =
        new QuestionPresenter(viewModel, router);
    QuestionModel model = new QuestionModel(activity);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    view.injectPresenter(presenter);

  }

  /*
  public static void configure(QuestionContract.View view) {

    WeakReference<FragmentActivity> activity = 
        new WeakReference<>((FragmentActivity) view);
    
    QuestionRouter router = new QuestionRouter();
    router.activity = new WeakReference<>(activity);

    QuestionPresenter presenter = new QuestionPresenter();
    presenter.viewModel =
        ViewModelProviders.of(activity).get(QuestionViewModel.class);
    presenter.view = new WeakReference<QuestionContract.View>(activity);
    presenter.router = router;

    QuestionModel model = new QuestionModel(new WeakReference<>(activity));
    presenter.model = model;

    if (activity.presenter == null) {
      activity.presenter = presenter;
    }

  }
  */

}