package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.utils.Utils.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.utils.Utils;

public class AuthElements {
    public ViewInteraction loginField = onView(allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout)))));
    public ViewInteraction passwordField = onView(allOf(withHint("Password"), withParent(withParent(withId(R.id.password_text_input_layout)))));
    public ViewInteraction enter = onView(allOf(withId(R.id.enter_button), withText("Sign in"), withContentDescription("Save"), childAtPosition(childAtPosition(withClassName(is("android.widget.RelativeLayout")), 1), 2), isDisplayed()));
    public ViewInteraction screen = onView(allOf(withText("Authorization"), withParent(withParent(withId(R.id.nav_host_fragment))), isDisplayed()));
    public ViewInteraction empty = onView(withText(R.string.empty_login_or_password))
            .inRoot(new Utils.ToastMatcher());
    public ViewInteraction wrong = onView(withText(R.string.wrong_login_or_password))
            .inRoot(new Utils.ToastMatcher());
}
