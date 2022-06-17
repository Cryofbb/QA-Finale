package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.MenuElements;

public class MenuScreen {
    MenuElements Menu = new MenuElements();

    public void openClaims() {
        Allure.step("Открытие раздела Claims");
        Menu.open.perform(click());
        Menu.claims.perform(click());
        Menu.claimsScreen.check(matches(isDisplayed()));
    }

    public void openNews() {
        Allure.step("Открытие раздела News");
        Menu.open.perform(click());
        Menu.news.perform(click());
        Menu.newsScreen.check(matches(isDisplayed()));
    }

    public void openAbout() {
        Allure.step("Открытие раздела About");
        Menu.open.perform(click());
        Menu.about.perform(click());
        Menu.aboutScreen.check(matches(isDisplayed()));
    }

    public void openMain() {
        Allure.step("Открытие главного окна");
        Menu.open.perform(click());
        Menu.main.perform(click());
        Menu.mainScreen.check(matches(isDisplayed()));
    }

    public void openQuotes() {
        Allure.step("Открытие раздела цитат");
        Menu.quotes.perform(click());
        Menu.quotesScreen.check(matches(isDisplayed()));
    }

    public void logOut() {
        Allure.step("Выход из приложения");
        Menu.profile.perform(click());
        Menu.signOut.perform(click());
        Menu.authScreen.check(matches(isDisplayed()));
    }

    public void logoClick() {
        Allure.step("Нажатие на логотип");
        Menu.logo.perform(click());
    }
}
