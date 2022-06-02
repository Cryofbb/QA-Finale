package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static org.hamcrest.Matchers.not;

import ru.iteco.fmhandroid.ui.elements.EditNewsElements;

public class EditingNewsScreen {
    EditNewsElements News = new EditNewsElements();

    public void onScreen() {
        News.screen.check(matches(isDisplayed()));
    }

    public void delete() {
        News.delete.perform(click());
        News.okPopup.perform(click());
    }

    public void edit() {
        News.edit.perform(click());
        News.editing.check(matches(isDisplayed()));
    }

    public void add() {
        News.addNew.perform(click());
        News.creating.check(matches(isDisplayed()));
    }

    public void expand() {
        News.expand.perform(click());
        News.description.check(matches(isDisplayed()));
    }

    public void collapse() {
        News.expand.perform(click());
        News.description.check(matches(not(isDisplayed())));
    }

    public void categorySelect() {
        News.editCategory.perform(click());
        News.editDate.perform(click());
    }

    public void enterTitle(String title) {
        News.editTitle.perform(replaceText(title));
    }

    public void enterDescription(String description) {
        News.editDescription.perform(replaceText(description));
    }

    public void enterDate(String date) {
        News.editDate.perform(replaceText(date));
    }

    public void enterTime(String time) {
        News.editTime.perform(replaceText(time));
    }

    public void saveButton() {
        News.save.perform(click());
    }

    public void checkboxActive() {
        News.checkboxActive.perform(click());
    }

    public void checkboxNotActive() {
        News.checkboxNotActive.perform(click());
    }

    public void checkCheckboxActive(boolean checked) {
        if (checked) {
            News.checkboxActive.check(matches(isChecked()));
        } else {
            News.checkboxActive.check(matches(isNotChecked()));
        }
    }

    public void checkCheckboxNotActive(boolean checked) {
        if (checked) {
            News.checkboxNotActive.check(matches(isChecked()));
        } else {
            News.checkboxNotActive.check(matches(isNotChecked()));
        }
    }
}
