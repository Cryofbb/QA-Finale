package ru.fmhandroid.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import ru.fmhandroid.elements.EditClaimElements;

public class EditingClaimsScreen {
    EditClaimElements Edit = new EditClaimElements();

    public void onScreen() {
        Edit.screen.check(matches(isDisplayed()));
        Edit.subscreen.check(matches(isDisplayed()));
    }

    public void enterTitle(String text) {
        Edit.title.perform(replaceText(text));
    }

    public void enterDate(String text) {
        Edit.date.perform(replaceText(text));
    }

    public void enterTime(String text) {
        Edit.time.perform(replaceText(text));
    }

    public void enterDescription(String text) {
        Edit.description.perform(replaceText(text));
    }

    public void enterExecutor() {
        Edit.executor.perform(click());
        Edit.date.perform(click());
    }

    public void save() {
        Edit.save.perform(click());
    }

    public void cancel() {
        Edit.cancel.perform(click());
        Edit.okPopup.perform(click());
    }

    public void checkFields() {
        Edit.emptyFieldsWarning.check(matches(isDisplayed()));
    }
}
