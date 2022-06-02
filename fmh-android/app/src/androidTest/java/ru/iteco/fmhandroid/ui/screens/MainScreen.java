package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.not;

import ru.iteco.fmhandroid.ui.elements.MainElements;

public class MainScreen {
    MainElements Main = new MainElements();
    public void onScreen(){
        Main.allNews.check(matches(isDisplayed()));
    }
    public void expandAllNews() {
        Main.expandAllNews.perform(click());
        Main.allNews.check(matches(isDisplayed()));
    }

    public void expandAllClaims() {
        Main.expandAllClaims.perform(click());
        Main.addClaim.check(matches(isDisplayed()));
    }

    public void collapseAllNews() {
        Main.expandAllNews.perform(click());
        Main.allNews.check(matches(not(isDisplayed())));
    }

    public void collapseAllClaims() {
        Main.expandAllClaims.perform(click());
        Main.allClaims.check(matches(not(isDisplayed())));
    }

    public void expandSingleNews() {
        Main.title.perform(click());
        Main.description.check(matches(isDisplayed()));
    }

    public void collapseSingleNews() {
        Main.title.perform(click());
        Main.description.check(matches(not(isDisplayed())));
    }

    public void openAllNews() {
        Main.allNews.perform(click());
        Main.news.check(matches(isDisplayed()));
        Main.claims.check(matches(not(isDisplayed())));
    }

    public void openAllClaims() {
        Main.allClaims.perform(click());
        Main.claims.check(matches(isDisplayed()));
        Main.news.check(matches(not(isDisplayed())));
    }

    public void addNewClaim() {
        Main.addClaim.perform(click());
        Main.creating.check(matches(isDisplayed()));
    }

    public void openClaim() {
        Main.executor.perform(click());
        Main.news.check(matches(not(isDisplayed())));
    }

    public void backFromClaim() {
        Main.closeClaim.perform(click());
        Main.news.check(matches(isDisplayed()));
    }

}
