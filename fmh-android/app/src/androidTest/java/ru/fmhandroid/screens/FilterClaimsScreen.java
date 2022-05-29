package ru.fmhandroid.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;

import ru.fmhandroid.elements.FilterClaimsElements;

public class FilterClaimsScreen {
    FilterClaimsElements Filter = new FilterClaimsElements();

    public void openCheck() {
        Filter.open.perform(click());
    }

    public void checkboxOpen(boolean checked) {
        if (checked) {
            Filter.open.check(matches(isChecked()));
        } else {
            Filter.open.check(matches(isNotChecked()));
        }
    }

    public void inProgressCheck() {
        Filter.inProgress.perform(click());
    }

    public void checkboxInProgress(boolean checked) {
        if (checked) {
            Filter.inProgress.check(matches(isChecked()));
        } else {
            Filter.inProgress.check(matches(isNotChecked()));
        }
    }

    public void executedCheck() {
        Filter.executed.perform(click());
    }

    public void checkboxExecuted(boolean checked) {
        if (checked) {
            Filter.executed.check(matches(isChecked()));
        } else {
            Filter.executed.check(matches(isNotChecked()));
        }
    }

    public void cancelledCheck() {
        Filter.cancelled.perform(click());
    }

    public void checkboxCancelled(boolean checked) {
        if (checked) {
            Filter.cancelled.check(matches(isChecked()));
        } else {
            Filter.cancelled.check(matches(isNotChecked()));
        }
    }

    public void apply() {
        Filter.apply.perform(click());
    }


    public void cancel() {
        Filter.cancel.perform(click());
    }


}
