package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.utils.Utils.isDisplayedWithSwipe;

import android.os.SystemClock;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.RootMatchers;

import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.EditNewsElements;

public class CreateNewsStep {
    EditNewsElements News = new EditNewsElements();

    public void onScreen() {
        Allure.step("Нахождение в окне редактирования новостей");
        News.screen.check(matches(isDisplayed()));
    }

    public void delete() {
        Allure.step("Удаление новости");
        News.delete.perform(click());
        News.okPopup.perform(click());
    }
    public void expandWithTitle(String title) {
        Allure.step("Удаление новости" + title);
        onView(allOf(withId(R.id.news_item_title_text_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(title)))))))).perform(click());
        onView(allOf(withId(R.id.news_item_description_text_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(title)))))))).check(matches(isDisplayed()));
    }
    public void collapseWithTitle(String title) {
        Allure.step("Удаление новости" + title);
        onView(allOf(withId(R.id.news_item_title_text_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(title)))))))).perform(click());
        onView(allOf(withId(R.id.news_item_description_text_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(title)))))))).check(matches(not(isDisplayed())));
    }
    public void deleteWithTitle(String title) {
        Allure.step("Удаление новости" + title);
        onView(allOf(withId(R.id.delete_news_item_image_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(title)))))))).perform(click());
        News.okPopup.perform(click());
    }

    public void edit(String title) {
        Allure.step("Редактирование новости" + title);
        onView(allOf(withId(R.id.edit_news_item_image_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(title)))))))).perform(click());
        News.editing.check(matches(isDisplayed()));
    }

    public void add() {
        Allure.step("Добавление новости");
        News.addNew.perform(click());
        News.creating.check(matches(isDisplayed()));
    }

    public void categorySelect() {
        Allure.step("Выбор категории");
        News.editCategory.perform(click());
        News.editDate.perform(click());
    }

    public void categorySelector() {
        Allure.step("Выбор категории");
        News.editCategory.perform(click());
        SystemClock.sleep(3000);
        onData(Matchers.anything())
                .inRoot(RootMatchers.isPlatformPopup())
                .atPosition(1)
                .perform(ViewActions.click());
    }

    public void enterTitle(String title) {
        Allure.step("Ввод заголовка " + title);
        News.editTitle.perform(replaceText(title));
    }

    public void enterDescription(String description) {
        Allure.step("Ввод описания" + description);
        News.editDescription.perform(replaceText(description));
    }

    public void enterDate(String date) {
        Allure.step("Ввод даты" + date);
        News.editDate.perform(replaceText(date));
    }

    public void enterTime(String time) {
        Allure.step("Ввод времени" + time);
        News.editTime.perform(replaceText(time));
    }

    public void saveButton() {
        Allure.step("Нажатие кнопки сохранить");
        News.save.perform(click());
        SystemClock.sleep(1500);
    }

    public void checkDate(String text) {
        Allure.step("Проверка даты");
        News.date.check(matches(withText(text)));
    }

    public void editStatus() {
        Allure.step("Смена статуса");
        News.editStatus.perform(click());
    }

    public void checkIsDisplayed(String title) {
        Allure.step("Проверка отображения новости с заголовком");
        if (isDisplayedWithSwipe(onView(withText(title)), 1, true)) {
            onView(withText(title)).check(matches(isDisplayed()));
        }
    }

    public void expandSingleNews() {
        Allure.step("Раскрытие новости");
        News.titleIndex.perform(click());
        SystemClock.sleep(3000);
        News.description.check(matches(isDisplayed()));
    }

    public void collapseSingleNews() {
        Allure.step("Сворачивание новости");
        News.status.perform(click());
        SystemClock.sleep(3000);
        News.descriptionCollapsed.check(matches(not(isDisplayed())));
    }

    public void fillNewsAndCheckFields(String date, String time, String title, String description){
        Allure.step("Выбор категории");
        News.editCategory.perform(click());
        SystemClock.sleep(3000);
        onData(Matchers.anything())
                .inRoot(RootMatchers.isPlatformPopup())
                .atPosition(1)
                .perform(ViewActions.click());
        Allure.step("Ввод заголовка " + title);
        News.editTitle.perform(replaceText(title));
        Allure.step("Ввод описания" + description);
        News.editDescription.perform(replaceText(description));
        Allure.step("Ввод даты" + date);
        News.editDate.perform(replaceText(date));
        Allure.step("Ввод времени" + time);
        News.editTime.perform(replaceText(time));
        closeSoftKeyboard();
        Allure.step("Проверка заголовка " + title);
        News.editTitle.check(matches(withText(title)));
        Allure.step("Проверка описания" + description);
        News.editDescription.check(matches(withText(description)));
        Allure.step("Проверка даты" + date);
        News.editDate.check(matches(withText(date)));
        Allure.step("Проверка времени" + time);
        News.editTime.check(matches(withText(time)));}
}
