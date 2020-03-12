package es.ulpgc.eite.cleancode.quiz;


import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.cleancode.quiz.cheat.CheatActivity;
import es.ulpgc.eite.cleancode.quiz.question.QuestionActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CheatTest {

  private static final long DELAY = 0;


  @Rule
  public ActivityTestRule<QuestionActivity> mActivityTestRule =
      new ActivityTestRule<>(QuestionActivity.class);


  @Rule
  public ActivityTestRule<CheatActivity> mActivityTestRule2 =
      new ActivityTestRule<>(CheatActivity.class);

  @Test
  public void instrumentedTest() {

    ViewInteraction appCompatButton = onView(allOf(
        withId(R.id.trueButton), withText("True"), isDisplayed()));
    appCompatButton.perform(click());


    ViewInteraction appCompatButton2 = onView(allOf(
        withId(R.id.nextButton), withText("Next"), isDisplayed()));
    appCompatButton2.perform(click());

    ViewInteraction textView = onView(allOf(
        withId(R.id.questionText),
        withText("The Gremlins movie was released in 1986?"),
        isDisplayed()
    ));
    textView.check(matches(
        withText("The Gremlins movie was released in 1986?")));


    ViewInteraction appCompatButton3 = onView(allOf(
        withId(R.id.cheatButton), withText("Cheat"), isDisplayed()));
    appCompatButton3.perform(click());


    ViewInteraction appCompatButton4 = onView(allOf(
        withId(R.id.noButton), withText("No"), isDisplayed()));
    appCompatButton4.perform(click());



    ViewInteraction textView2 = onView(allOf(
        withId(R.id.questionText),
        withText("The Gremlins movie was released in 1986?"),
        isDisplayed()
    ));
    textView2.check(matches(
        withText("The Gremlins movie was released in 1986?")));

    ViewInteraction appCompatButton5 = onView(allOf(
        withId(R.id.cheatButton), withText("Cheat"), isDisplayed()));
    appCompatButton5.perform(click());


    try {

      Thread.sleep(DELAY);

      UiDevice device = UiDevice.getInstance(getInstrumentation());
      device.setOrientationLeft();

      Thread.sleep(DELAY);

    } catch (Exception e) {
      e.printStackTrace();
    }

    /*
    mActivityTestRule2.getActivity()
        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    */

    ViewInteraction appCompatButton6 = onView(allOf(
        withId(R.id.yesButton), withText("Yes"), isDisplayed()));
    appCompatButton6.perform(click());

    ViewInteraction textView3 = onView(allOf(
        withId(R.id.answerText), withText("False"), isDisplayed()));
    textView3.check(matches(withText("False")));

    try {

      Thread.sleep(DELAY);

      UiDevice device = UiDevice.getInstance(getInstrumentation());
      device.setOrientationNatural();

      Thread.sleep(DELAY);

    } catch (Exception e) {
      e.printStackTrace();
    }

    /*
    mActivityTestRule2.getActivity()
        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    */


    ViewInteraction textView4 = onView(allOf(
        withId(R.id.answerText), withText("False"), isDisplayed()));
    textView4.check(matches(withText("False")));

    pressBack();



    ViewInteraction textView5 = onView(allOf(
        withId(R.id.questionText),
        withText("Brad Pitt played Danny Ocean in Ocean's Eleven, " +
            "Ocean's Twelve and Ocean's Thirteen?"),
        isDisplayed()
    ));
    textView5.check(matches(
        withText("Brad Pitt played Danny Ocean in Ocean's Eleven, " +
            "Ocean's Twelve and Ocean's Thirteen?")));
  }

}
