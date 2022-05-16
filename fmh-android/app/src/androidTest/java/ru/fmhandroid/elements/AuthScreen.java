package ru.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthScreen {
    public ViewInteraction loginTextInputField = onView(withId(R.id.login_text_input_layout));
    public ViewInteraction passwordTextInputField = onView(withId(R.id.password_text_input_layout));
    public ViewInteraction authEnterButton = onView(withId(R.id.enter_button));
    public ViewInteraction authScreenText = onView(allOf(withText("Authorization")));
}
