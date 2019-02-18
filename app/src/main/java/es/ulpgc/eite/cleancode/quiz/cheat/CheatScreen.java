package es.ulpgc.eite.cleancode.quiz.cheat;

import java.lang.ref.WeakReference;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;

public class CheatScreen {


  public static void configure(CheatContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    CheatState state = mediator.getCheatState();

    /*
    CheatViewModel viewModel = 
        ViewModelProviders.of(context.get()).get(CheatViewModel.class);
    */
    
    //CheatContract.Router router = new CheatRouter(context);
    CheatContract.Router router = new CheatRouter(mediator);
    //CheatContract.Presenter presenter = new CheatPresenter(viewModel, router);
    //CheatContract.Presenter presenter = new CheatPresenter(context);
    CheatContract.Presenter presenter = new CheatPresenter(state);
    //CheatModel model = new CheatModel(context);
    //CheatModel model = new CheatModel();
    presenter.injectView(new WeakReference<>(view));
    //presenter.injectModel(model);
    presenter.injectRouter(router);
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
