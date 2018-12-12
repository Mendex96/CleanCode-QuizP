package es.ulpgc.eite.cleancode.quiz.cheat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.eite.cleancode.quiz.R;


public class CheatActivity
    extends AppCompatActivity implements CheatContract.View {

  public static String TAG = CheatActivity.class.getSimpleName();

  CheatContract.Presenter presenter;

  TextView confirmationText, cheatText;
  Button yesButton, noButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cheat);

    getSupportActionBar().setTitle(R.string.cheat_screen_title);

    yesButton = findViewById(R.id.yesButton);
    noButton = findViewById(R.id.noButton);
    confirmationText = findViewById(R.id.confirmationText);
    cheatText = findViewById(R.id.cheatText);

    yesButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        presenter.yesButtonClicked();
      }
    });

    noButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        presenter.noButtonClicked();
      }
    });

    // do the setup
    CheatScreen.configure(this);

    // do some work
    presenter.fetchCheatData();
  }


  @Override
  public void injectPresenter(CheatContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayCheatData(CheatViewModel viewModel) {
    Log.e(TAG, "displayCheatData()");

    // deal with the data
    yesButton.setText(viewModel.yesLabel);
    noButton.setText(viewModel.noLabel);

    confirmationText.setText(viewModel.confirmationText);
    cheatText.setText(viewModel.cheatText);

    yesButton.setEnabled(viewModel.yesButton);
    noButton.setEnabled(viewModel.noButton);
  }
}
