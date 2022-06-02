package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.*;

import static ru.iteco.fmhandroid.ui.utils.Utils.childAtPosition;
import static ru.iteco.fmhandroid.utils.Utils.*;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class AuthElements {
    public ViewInteraction loginField = onView(allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout)))));
    public ViewInteraction passwordField = onView(allOf(withHint("Password"), withParent(withParent(withId(R.id.password_text_input_layout)))));
    public ViewInteraction enter = onView(allOf(withId(R.id.enter_button), withText("Sign in"), withContentDescription("Save"),childAtPosition(childAtPosition(withClassName(is("android.widget.RelativeLayout")),1),2),isDisplayed()));
    public ViewInteraction screen = onView(allOf(withText("Authorization"),withParent(withParent(withId(R.id.nav_host_fragment))),isDisplayed()));
}
