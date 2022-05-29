package ru.fmhandroid.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import ru.fmhandroid.elements.MenuElements;

public class MenuScreen {
    MenuElements Menu = new MenuElements();

    public void menuClick() {
        Menu.open.perform(click());
    }

    public void openClaims() {
        menuClick();
        Menu.claims.check(matches(isClickable()));
        Menu.claims.perform(click());
        Menu.claimsScreen.check(matches(isDisplayed()));
    }

    public void openNews() {
        menuClick();
        Menu.news.check(matches(isClickable()));
        Menu.news.perform(click());
        Menu.newsScreen.check(matches(isDisplayed()));
    }

    public void openAbout() {
        menuClick();
        Menu.about.check(matches(isClickable()));
        Menu.about.perform(click());
        Menu.aboutScreen.check(matches(isDisplayed()));
    }

    public void openMain() {
        menuClick();
        Menu.main.check(matches(isClickable()));
        Menu.main.perform(click());
        Menu.mainScreen.check(matches(isDisplayed()));
    }

    public void openQuotes() {
        Menu.quotes.perform(click());
        Menu.quotesScreen.check(matches(isDisplayed()));
    }

    public void logOut() {
        Menu.profile.perform(click());
        Menu.signOut.perform(click());
        Menu.authScreen.check(matches(isDisplayed()));
    }

    public void logoClick() {
        Menu.logo.perform(click());
    }

}