package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import ru.iteco.fmhandroid.ui.elements.ClaimsElements;

public class ClaimsScreen {
    ClaimsElements Claims = new ClaimsElements();

    public void onScreen() {
        Claims.screen.check(matches(isDisplayed()));
    }

    public void open() {
        Claims.openClaim.perform(click());
    }

    public void goBack() {
        Claims.closeClaim.perform(click());
    }

    public void addNew() {
        Claims.addNew.perform(click());
    }

    public void filter() {
        Claims.openFilter.perform(click());
    }
}
