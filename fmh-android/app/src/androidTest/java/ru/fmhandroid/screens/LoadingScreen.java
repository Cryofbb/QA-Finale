package ru.fmhandroid.screens;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import ru.fmhandroid.elements.LoadingElements;

public class LoadingScreen {
    LoadingElements Loading = new LoadingElements();

    public void checkLoading() {
        Loading.splashScreen.check(matches(isDisplayed()));
        Loading.splashText.check(matches(isDisplayed()));
    }
}
