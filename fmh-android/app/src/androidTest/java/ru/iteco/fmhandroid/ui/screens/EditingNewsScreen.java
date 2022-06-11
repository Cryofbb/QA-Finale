package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

import static ru.iteco.fmhandroid.ui.utils.Utils.isDisplayedWithSwipe;

import android.os.SystemClock;

import androidx.test.espresso.matcher.ViewMatchers;

import ru.iteco.fmhandroid.R;
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
    public void deleteWithTitle(String title){
        onView(allOf(withId(R.id.delete_news_item_image_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(title)))))))).perform(click());
        News.okPopup.perform(click());
    }

    public void edit(String title) {
        onView(allOf(withId(R.id.edit_news_item_image_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(title)))))))).perform(click());
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
    public void expandSingleNews() {
        News.titleIndex.perform(click());
        //News.title.perform(actionOnItemAtPosition(0, click()));
        News.description.check(matches(isDisplayed()));
    }

    public void collapseSingleNews() {
        News.status.perform(click());
        News.descriptionCollapsed.check(matches(not(isDisplayed())));
    }

    public void enterDate(String date) {
        News.editDate.perform(replaceText(date));
    }

    public void enterTime(String time) {
        News.editTime.perform(replaceText(time));
    }

    public void saveButton() {
        News.save.perform(click());
        SystemClock.sleep(1500);
    }
    public void checkDate(String text) {
        News.date.check(matches(withText(text)));
    }
    public void editStatus() {
        News.editStatus.perform(click());
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
    public void checkIsDisplayed(String title){
        if (isDisplayedWithSwipe(onView(withText(title)), 1, true)) {
            onView(withText(title)).check(matches(isDisplayed()));
        }
    }
}
