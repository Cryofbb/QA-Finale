package ru.iteco.fmhandroid.uitest;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.MenuStep;

@RunWith(AllureAndroidJUnit4.class)
public class AuthTest {
    AuthStep Auth = new AuthStep();
    MenuStep Menu = new MenuStep();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        SystemClock.sleep(3000);
        try {
            Auth.onScreen();
        } catch (NoMatchingViewException e) {
            Menu.logOut();
        }
    }

    @Test
    @DisplayName("Проверка входа с пустой формой")
    public void emptyAuth() {
        Auth.onScreen();
        Auth.buttonClick();
        Auth.checkEmpty();
    }

    @Test
    @DisplayName("Проверка входа с заполнением пробелами формой")
    public void blankAuth() {
        Auth.onScreen();
        Auth.loginFill(" ");
        Auth.passwordFill(" ");
        Auth.buttonClick();
        Auth.checkEmpty();
    }

    @Test
    @DisplayName("Проверка входа с неверными данными")
    public void wrongAuth() {
        Auth.onScreen();
        Auth.loginFill("неверные");
        Auth.passwordFill("данные");
        Auth.buttonClick();
        Allure.step("Отображение ");
        Auth.checkWrong();
    }

    @Test
    @DisplayName("Вход с валидными данными и последующий выход")
    public void signInOK() {
        Auth.onScreen();
        Auth.validAuth();
        Menu.logOut();
    }
}