package es.ulpgc.eite.cleancode.quiz.question;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.eite.cleancode.quiz.R;


public class QuestionActivity
    extends AppCompatActivity implements QuestionContract.View {

  public static String TAG = QuestionActivity.class.getSimpleName();

  QuestionContract.Presenter presenter;

  TextView questionText, answerText;
  Button trueButton, falseButton, cheatButton, nextButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_question);

    getSupportActionBar().setTitle(R.string.question_screen_title);

    trueButton = findViewById(R.id.trueButton);
    falseButton = findViewById(R.id.falseButton);
    cheatButton = findViewById(R.id.cheatButton);
    nextButton = findViewById(R.id.nextButton);
    questionText = findViewById(R.id.confirmationText);
    answerText = findViewById(R.id.cheatText);

    trueButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        presenter.trueButtonClicked();
      }
    });

    falseButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        presenter.falseButtonClicked();
      }
    });

    cheatButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        presenter.cheatButtonClicked();
      }
    });

    nextButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        presenter.nextButtonClicked();
      }
    });

    // do the setup
    QuestionConfigurator.INSTANCE.configure(this);

  }


  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchQuestionData();
  }

  @Override
  public void displayQuestionData(QuestionViewModel viewModel) {
    Log.e(TAG, "displayQuestionData()");

    // deal with the data
    trueButton.setText(viewModel.trueLabel);
    falseButton.setText(viewModel.falseLabel);
    cheatButton.setText(viewModel.cheatLabel);
    nextButton.setText(viewModel.nextLabel);

    questionText.setText(viewModel.questionText);
    answerText.setText(viewModel.answerText);

    trueButton.setEnabled(viewModel.trueButton);
    falseButton.setEnabled(viewModel.falseButton);
    cheatButton.setEnabled(viewModel.cheatButton);
    nextButton.setEnabled(viewModel.nextButton);

    //Log.e(TAG, "data: " + viewModel.data + ")");
  }
}
