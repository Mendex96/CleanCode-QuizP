package es.ulpgc.eite.cleancode.quiz.cheat;

import java.lang.ref.WeakReference;

import android.arch.lifecycle.ViewModelProviders;

// include this library dependency in build.gradle file
// implementation 'android.arch.lifecycle:extensions:1.1.1'
public enum CheatConfigurator {

  INSTANCE;

  public void configure(CheatActivity activity) {

    CheatRouter router = new CheatRouter();
    router.activity = new WeakReference<>(activity);

    CheatPresenter presenter = new CheatPresenter();
    presenter.viewModel =
        ViewModelProviders.of(activity).get(CheatViewModel.class);
    presenter.view = new WeakReference<CheatContract.View>(activity);
    presenter.router = router;

    CheatModel model = new CheatModel(new WeakReference<>(activity));
    presenter.model = model;

    if (activity.presenter == null) {
      activity.presenter = presenter;
    }

  }
}
