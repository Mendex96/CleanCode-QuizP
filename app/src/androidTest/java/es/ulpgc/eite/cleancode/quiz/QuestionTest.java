package es.ulpgc.eite.cleancode.quiz;


import android.content.pm.ActivityInfo;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.cleancode.quiz.question.QuestionActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class QuestionTest {

  @Rule
  public ActivityTestRule<QuestionActivity> mActivityTestRule =
      new ActivityTestRule<>(QuestionActivity.class);

  @Test
  public void instrumentedTest() {

    ViewInteraction textView = onView(allOf(
        withId(R.id.questionText),
        withText("Christian Bale played Batman in 'The Dark Knight Rises'?"),
        isDisplayed()
    ));
    textView.check(matches(
        withText("Christian Bale played Batman in 'The Dark Knight Rises'?")));

    ViewInteraction appCompatButton = onView(allOf(
        withId(R.id.trueButton), withText("True"), isDisplayed()));
    appCompatButton.perform(click());

    ViewInteraction textView2 = onView(allOf(
        withId(R.id.questionText),
        withText("Christian Bale played Batman in 'The Dark Knight Rises'?"),
        isDisplayed()
    ));
    textView2.check(matches(
        withText("Christian Bale played Batman in 'The Dark Knight Rises'?")));

    ViewInteraction textView3 = onView(allOf(
        withId(R.id.resultText), withText("Correct!"), isDisplayed()));
    textView3.check(matches(withText("Correct!")));

    ViewInteraction appCompatButton2 = onView(allOf(
        withId(R.id.nextButton), withText("Next"), isDisplayed()));
    appCompatButton2.perform(click());

    ViewInteraction textView4 = onView(allOf(
        withId(R.id.questionText),
        withText("The Gremlins movie was released in 1986?"),
        isDisplayed()
    ));
    textView4.check(matches(
        withText("The Gremlins movie was released in 1986?")));

    ViewInteraction appCompatButton3 = onView(allOf(
        withId(R.id.trueButton), withText("True"), isDisplayed()));
    appCompatButton3.perform(click());

    ViewInteraction textView5 = onView(allOf(
        withId(R.id.questionText),
        withText("The Gremlins movie was released in 1986?"),
        isDisplayed()
    ));
    textView5.check(matches(
        withText("The Gremlins movie was released in 1986?")));

    ViewInteraction textView6 = onView(allOf(
        withId(R.id.resultText), withText("Incorrect!"), isDisplayed()));
    textView6.check(matches(withText("Incorrect!")));

        /*
        // Added a sleep statement to match the app's execution delay.
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    mActivityTestRule.getActivity()
        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


    ViewInteraction textView7 = onView(allOf(
        withId(R.id.resultText), withText("Incorrect!"), isDisplayed()));
    textView7.check(matches(withText("Incorrect!")));

    ViewInteraction textView8 = onView(allOf(
        withId(R.id.questionText),
        withText("The Gremlins movie was released in 1986?"),
        isDisplayed()
    ));
    textView8.check(matches(
        withText("The Gremlins movie was released in 1986?")));

    ViewInteraction appCompatButton4 = onView(allOf(
        withId(R.id.nextButton), withText("Next"), isDisplayed()));
    appCompatButton4.perform(click());

    ViewInteraction textView9 = onView(allOf(
        withId(R.id.questionText),
        withText("Brad Pitt played Danny Ocean in Ocean's Eleven, " +
            "Ocean's Twelve and Ocean's Thirteen?"),
        isDisplayed()
    ));
    textView9.check(matches(
        withText("Brad Pitt played Danny Ocean in Ocean's Eleven, " +
            "Ocean's Twelve and Ocean's Thirteen?")));

    ViewInteraction appCompatButton5 = onView(allOf(
        withId(R.id.falseButton), withText("False"), isDisplayed()));
    appCompatButton5.perform(click());

    ViewInteraction textView10 = onView(allOf(
        withId(R.id.questionText),
        withText("Brad Pitt played Danny Ocean in Ocean's Eleven, " +
            "Ocean's Twelve and Ocean's Thirteen?"),
        isDisplayed()
    ));
    textView10.check(matches(
        withText("Brad Pitt played Danny Ocean in Ocean's Eleven, " +
            "Ocean's Twelve and Ocean's Thirteen?")));

    ViewInteraction textView11 = onView(allOf(
        withId(R.id.resultText), withText("Correct!"), isDisplayed()));
    textView11.check(matches(withText("Correct!")));

        /*// Added a sleep statement to match the app's execution delay.
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    mActivityTestRule.getActivity()
        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


    ViewInteraction textView12 = onView(allOf(
        withId(R.id.questionText),
        withText("Brad Pitt played Danny Ocean in Ocean's Eleven, " +
            "Ocean's Twelve and Ocean's Thirteen?"),
        isDisplayed()
    ));
    textView12.check(matches(
        withText("Brad Pitt played Danny Ocean in Ocean's Eleven, " +
            "Ocean's Twelve and Ocean's Thirteen?")));

    ViewInteraction textView13 = onView(allOf(
        withId(R.id.resultText), withText("Correct!"), isDisplayed()));
    textView13.check(matches(withText("Correct!")));

    ViewInteraction appCompatButton6 = onView(allOf(
        withId(R.id.nextButton), withText("Next"), isDisplayed()));
    appCompatButton6.perform(click());

    ViewInteraction textView14 = onView(allOf(
        withId(R.id.questionText),
        withText("A spoon full of sugar' came from the 1964 movie Mary Poppins?"),
        isDisplayed()
    ));
    textView14.check(matches(
        withText("A spoon full of sugar' came from the 1964 movie Mary Poppins?")));
  }

    /*
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
    */
}
