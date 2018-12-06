package es.ulpgc.eite.cleancode.quiz.question;

import java.lang.ref.WeakReference;

import android.arch.lifecycle.ViewModelProviders;

// include this library dependency in build.gradle file
// implementation 'android.arch.lifecycle:extensions:1.1.1'
public enum QuestionConfigurator {

  INSTANCE;

  public void configure(QuestionActivity activity) {

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
}
