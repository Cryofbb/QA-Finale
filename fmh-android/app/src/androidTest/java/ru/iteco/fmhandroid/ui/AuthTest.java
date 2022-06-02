package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import android.os.Environment;
import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screens.AuthScreen;
import ru.iteco.fmhandroid.ui.screens.MenuScreen;
import ru.iteco.fmhandroid.ui.utils.Utils;

@RunWith(AllureAndroidJUnit4.class)
public class AuthTest {
    AuthScreen Auth = new AuthScreen();
    MenuScreen Menu = new MenuScreen();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Before
    public void createAllureDir() {
        File path = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/allure-results/"
        );
        if (!path.exists()) {
            path.mkdirs();
        }
    }
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
        onView(withText(R.string.empty_login_or_password))
                .inRoot(new Utils.ToastMatcher())
                .check(matches(isDisplayed()));
    }
    @Test
    @DisplayName("Проверка входа с заполнением пробелами формой")
    public void blankAuth() {
        Auth.onScreen();
        Auth.loginFill(" ");
        Auth.passwordFill(" ");
        Auth.buttonClick();
        onView(withText(R.string.empty_login_or_password))
                .inRoot(new Utils.ToastMatcher())
                .check(matches(isDisplayed()));
    }
    @Test
    @DisplayName("Проверка входа с неверными данными")
    public void wrongAuth() {
        Auth.onScreen();
        Auth.loginFill("неверные");
        Auth.passwordFill("данные");
        Auth.buttonClick();
        onView(withText(R.string.wrong_login_or_password))
                .inRoot(new Utils.ToastMatcher())
                .check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Вход с валидными данными и последующий выход")
    public void signInOK() {
        Auth.onScreen();
        Auth.loginFill("login2");
        Auth.passwordFill("password2");
        Auth.buttonClick();
        SystemClock.sleep(2500);
        Menu.logOut();
    }

}