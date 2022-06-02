package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import ru.iteco.fmhandroid.ui.elements.CreateClaimElements;

public class CreateClaimScreen {
    CreateClaimElements Create = new CreateClaimElements();

    public void onScreen() {

        Create.screen.check(matches(isDisplayed()));
        Create.subscreen.check(matches(isDisplayed()));
    }

    public void enterTitle(String text) {
        Create.title.perform(replaceText(text));
    }

    public void enterDate(String text) {
        Create.date.perform(replaceText(text));
    }

    public void enterTime(String text) {
        Create.time.perform(replaceText(text));
    }

    public void enterDescription(String text) {
        Create.description.perform(replaceText(text));
    }

    public void enterExecutor() {
        Create.executor.perform(click());
        Create.date.perform(click());
    }

    public void save() {
        Create.save.perform(click());
    }

    public void cancel() {
        Create.cancel.perform(click());
        Create.okPopup.perform(click());
    }

    public void checkFields() {
        Create.emptyFieldsWarning.check(matches(isDisplayed()));
    }
}
