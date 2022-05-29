package ru.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthElements {
    public ViewInteraction loginField = onView(withId(R.id.login_text_input_layout));
    public ViewInteraction passwordField = onView(withId(R.id.password_text_input_layout));
    public ViewInteraction enter = onView(withId(R.id.enter_button));
    public ViewInteraction screen = onView(allOf(withText("Authorization")));
    public ViewInteraction wrongPass = onView(withText(R.string.wrong_login_or_password));
    public ViewInteraction emptyPass = onView(withText(R.string.empty_login_or_password));

}
