package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.AuthElements;

public class AuthScreen {
    AuthElements Auth = new AuthElements();

    public void onScreen() {
        Allure.step("Проверка нахождение в окне авторизации");
        Auth.screen.check(matches(withText("Authorization")));
    }

    public void loginFill(String login) {
        Allure.step("Заполнение поля логина");
        Auth.loginField.check(matches(isEnabled()));
        Auth.loginField.perform(replaceText(login));
    }

    public void passwordFill(String password) {
        Allure.step("Заполнение поля пароля");
        Auth.passwordField.check(matches(isEnabled()));
        Auth.passwordField.perform(replaceText(password));
    }

    public void buttonClick() {
        Allure.step("Нажатие кнопки авторизации");
        Auth.enter.perform(click());
    }
    public void checkEmpty() {
        Allure.step("Предупреждение о недопустимости пустых полей");
        Auth.empty.check(matches(isDisplayed()));
    }
    public void checkWrong() {
        Allure.step("Предупреждение о неверных данных");
        Auth.wrong.check(matches(isDisplayed()));
    }
}
