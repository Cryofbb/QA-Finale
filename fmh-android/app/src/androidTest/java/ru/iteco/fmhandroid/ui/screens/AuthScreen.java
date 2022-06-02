package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import ru.iteco.fmhandroid.ui.elements.AuthElements;

public class AuthScreen {
    AuthElements Auth = new AuthElements();

    public void onScreen() {
        Auth.screen.check(matches(withText("Authorization")));
    }

    public void loginFill(String login) {
        Auth.loginField.check(matches(isEnabled()));
        Auth.loginField.perform(replaceText(login));
    }

    public void passwordFill(String password) {
        Auth.passwordField.check(matches(isEnabled()));
        Auth.passwordField.perform(replaceText(password));
    }

    public void buttonClick() {

        Auth.enter.perform(click());
    }
}
