package es.ulpgc.eite.cleancode.quiz.question;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.R;
import es.ulpgc.eite.cleancode.quiz.data.AppRepository;
import es.ulpgc.eite.cleancode.quiz.data.QuizRepository;

public class QuestionModel implements QuestionContract.Model {

  public static String TAG = QuestionModel.class.getSimpleName();


  /*
  private String[] quizQuestions = {
      "Christian Bale played Batman in 'The Dark Knight Rises'?", // 1
      "The Gremlins movie was released in 1986?",  // 2
      "Brad Pitt played Danny Ocean in Ocean's Eleven, Ocean's Twelve and Ocean's Thirteen?",  // 3
      "A spoon full of sugar' came from the 1964 movie Mary Poppins?",  // 4
//      "The song “I don't want to miss a thing” featured in Armageddon?", // 5
//      "Will Smith has a son called Jaden?", // 6
//      "Mark Ruffalo played Teddy Daniels in Shutter Island?", // 7
//      "Mike Myers starred in the 'Cat in the Hat' 2003 children's movie?", // 8
//      "Ryan Reynolds is married to Scarlett Johansson?", // 9
//      "The movie 'White House Down' was released in 2014?",  // 10
//      "Michael Douglas starred in Basic Instinct, Falling Down and The Game?", // 11
//      "Colin Firth won an Oscar for his performance in the historical movie 'The King's Speech'?",  // 12
//      "Cameron Diaz and Ashton Kutcher starred in the movie 'What happens in Vegas'?", // 13
//      "Arnold Schwarzenegger played lead roles in Rocky, Rambo and Judge Dredd?", // 14
//      "The Titanic movie featured the song 'My Heart Will Go On'?", // 15
//      "Eddie Murphy narrates the voice of Donkey in the Shrek movies?", // 16
//      "Nicole Kidman played Poison Ivy in 'Batman and Robin'?", // 17
//      "The Lara Croft: Tomb Raider movie was released in 2003?", // 18
//      "Hallie Berry played the character Rogue in X Men?", // 19
      "The Teenage Mutant Ninja Turtles are named after famous artists?" // 20
  };

  private boolean[] quizAnswers = {
      true, // 1
      false, // 2
      false, // 3
      true, // 4
//      true, // 5
//      true, // 6
//      false, // 7
//      true, // 8
//      false, // 9
//      false, // 10
//      true, // 11
//      true, // 12
//      true, // 13
//      false, // 14
//      true, // 15
//      true, // 16
//      false, // 17
//      false, // 18
//      false, // 19
      true // 20
  };
  */

  /*
  private String falseLabel = "False";
  private String trueLabel = "True";
  private String correctLabel = "Correct!";
  private String incorrectLabel = "Incorrect!";
  private String cheatLabel = "Cheat";
  private String nextLabel = "Next";
  */

  //private int quizIndex = 0;

  //private WeakReference<QuestionActivity> activity;
  private WeakReference<FragmentActivity> context;
  private final AppRepository repository;

  /*
  public QuestionModel(WeakReference<QuestionActivity> activity) {
    this.activity = activity;
  }
  */

  public QuestionModel(WeakReference<FragmentActivity> context) {
    this.context = context;

    repository = new QuizRepository();
  }


  @Override
  public String getCheatLabel() {
    //return cheatLabel;
    return context.get()
        .getResources().getString(R.string.cheat_label);
  }

  @Override
  public String getNextLabel() {
    //return nextLabel;
    return context.get()
        .getResources().getString(R.string.next_label);
  }

  @Override
  public String getFalseLabel() {
    //return falseLabel;
    return context.get()
        .getResources().getString(R.string.false_label);
  }


  @Override
  public String getTrueLabel() {
    //return trueLabel;
    return context.get()
        .getResources().getString(R.string.true_label);
  }

  /*
  @Override
  public String getCurrentQuestion() {
    String[] quizQuestions = repository.getQuestions();
    return quizQuestions[quizIndex];
  }

  @Override
  public boolean getCurrentAnswer() {
    boolean[] quizAnswers = repository.getAnswers();
    return quizAnswers[quizIndex];
  }

  @Override
  public boolean isQuizFinished() {
    String[] quizQuestions = repository.getQuestions();
    if(quizIndex == quizQuestions.length-1){
      return true;
    }


    return false;
  }
  */

  @Override
  public String getCurrentQuestion(int quizIndex) {
    String[] quizQuestions = repository.getQuestions();
    return quizQuestions[quizIndex];
  }

  @Override
  public boolean getCurrentAnswer(int quizIndex) {
    boolean[] quizAnswers = repository.getAnswers();
    return quizAnswers[quizIndex];
  }

  @Override
  public boolean isQuizFinished(int quizIndex) {
    String[] quizQuestions = repository.getQuestions();
    if(quizIndex == quizQuestions.length-1){
      return true;
    }


    return false;
  }

  @Override
  public String getIncorrectLabel() {
    //return incorrectLabel;
    return context.get()
        .getResources().getString(R.string.incorrect_label);
  }

  @Override
  public String getCorrectLabel() {
    //return correctLabel;
    return context.get()
        .getResources().getString(R.string.correct_label);
  }

  /*
  @Override
  public void incrQuizIndex() {
    quizIndex++;
  }
  */

}
