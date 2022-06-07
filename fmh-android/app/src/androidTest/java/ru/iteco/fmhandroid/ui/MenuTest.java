package ru.iteco.fmhandroid.ui;

import android.os.Environment;
import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.screens.AboutScreen;
import ru.iteco.fmhandroid.ui.screens.AuthScreen;
import ru.iteco.fmhandroid.ui.screens.MainScreen;
import ru.iteco.fmhandroid.ui.screens.MenuScreen;
import ru.iteco.fmhandroid.ui.screens.QuotesScreen;

@RunWith(AllureAndroidJUnit4.class)

public class MenuTest {
    AuthScreen Auth = new AuthScreen();
    MenuScreen Menu = new MenuScreen();
    QuotesScreen Quotes = new QuotesScreen();
    AboutScreen About = new AboutScreen();
    MainScreen Main = new MainScreen();

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
        Auth.loginFill("login2");
        Auth.passwordFill("password2");
        Auth.buttonClick();
        SystemClock.sleep(3000);
    }

    @After
    public void logOff() {
        Menu.logOut();
    }

    @Test
    @DisplayName("Открытие раздела цитат, сворачивание и разворачивание")
    public void quotesMenuCheck() {
        Menu.openQuotes();
        Quotes.onScreen();
        Quotes.expand();
        SystemClock.sleep(1000);
        Quotes.collapse();
    }

    @Test
    @DisplayName("Открытие окна About, проверка ссылок и версии")
    public void aboutMenuCheck() {
        Menu.openAbout();
        About.checkLinks();
        About.checkVersion();
        About.backButton();
        Main.onScreen();
    }


    @Test
    @DisplayName("Переход в заявки из меню")
    public void claimsMenuCheck() {
        Menu.openClaims();
    }

    @Test
    @DisplayName("Переход в новости из меню")
    public void newsMenuCheck() {
        Menu.openNews();
    }

    @Test
    @DisplayName("Возврат на главную страницу через меню")
    public void mainMenuCheck() {
        Menu.openQuotes();
        Menu.openMain();
    }

    @Test
    @DisplayName("Кликабельность логотипа")
    public void logoClickCheck() {
        Main.onScreen();
        Menu.logoClick();
        Main.onScreen();
    }
}
