package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import ru.iteco.fmhandroid.ui.elements.FilterNewsElements;

public class FilterNewsScreen {
    FilterNewsElements Filter = new FilterNewsElements();

    public void onScreen() {
        Filter.screen.check(matches(isDisplayed()));
    }

    public void filterCategory() {
        Filter.category.perform(click());
        Filter.dateStart.perform(click());
    }

    public void dateStart(String date) {
        Filter.dateStart.perform(replaceText(date));
    }

    public void dateEnd(String date) {
        Filter.dateEnd.perform(replaceText(date));
    }

    public void apply() {
        Filter.apply.perform(click());
    }

    public void cancel() {
        Filter.cancel.perform(click());
    }
    public void active() {
        Filter.active.perform(click());
    }
    public void notActive() {
        Filter.notActive.perform(click());
    }
}
