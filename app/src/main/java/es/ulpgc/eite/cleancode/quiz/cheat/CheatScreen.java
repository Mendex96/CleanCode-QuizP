package es.ulpgc.eite.cleancode.quiz.cheat;

import java.lang.ref.WeakReference;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;

public class CheatScreen {


  public static void configure(CheatContract.View view) {

    WeakReference<FragmentActivity> activity =
        new WeakReference<>((FragmentActivity) view);

    CheatViewModel viewModel = 
        ViewModelProviders.of(activity.get()).get(CheatViewModel.class);
    
    CheatContract.Router router = new CheatRouter(activity);
    CheatContract.Presenter presenter = new CheatPresenter(viewModel, router);
    CheatModel model = new CheatModel(activity);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    view.injectPresenter(presenter);

  }

  /*
  public static void configure(CheatContract.View view) {

    WeakReference<FragmentActivity> activity =
        new WeakReference<>((FragmentActivity) view);

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
  */

}
