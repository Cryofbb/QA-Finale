package ru.fmhandroid.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;

import ru.fmhandroid.elements.AuthElements;

public class AuthScreen {
    AuthElements Auth = new AuthElements();

    public void onScreen() {
        Auth.screen.check(matches(isDisplayed()));
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

    public void checkEmpty() {

        Auth.emptyPass.check(matches(isDisplayed()));
    }

    public void checkWrong() {

        Auth.wrongPass.check(matches(isDisplayed()));
    }
}
