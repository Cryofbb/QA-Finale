package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.repeatedlyUntil;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.Utils.swipeUpSlow;

import android.os.SystemClock;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.RootMatchers;

import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.CreateClaimElements;

public class CreateClaimStep {
    CreateClaimElements Create = new CreateClaimElements();

    public void onScreen() {
        Allure.step("Проверка ссылок");
        Create.screen.check(matches(isDisplayed()));
        Create.subscreen.check(matches(isDisplayed()));
    }

    public void enterTitle(String text) {

        Allure.step("Ввод заголовка");
        Create.title.perform(replaceText(text));
    }

    public void enterDate(String text) {

        Allure.step("Ввод даты");
        Create.date.perform(replaceText(text));
    }

    public void enterTime(String text) {

        Allure.step("Ввод времени");
        Create.time.perform(replaceText(text));
    }

    public void enterDescription(String text) {

        Allure.step("Ввод описания");
        Create.description.perform(replaceText(text));
    }

    public void enterExecutor() {
        Allure.step("Ввод исполнителя");
        Create.executor.perform(click());
        SystemClock.sleep(3000);
        onData(Matchers.anything())
                .inRoot(RootMatchers.isPlatformPopup())
                .atPosition(1)
                .perform(ViewActions.click());
    }

    public void save() {
        Allure.step("Проверка ссылок");
        Create.save.perform(click());
    }

    public void checkEmpty() {

        Allure.step("Проверка ссылок");
        Create.emptyFieldsWarning.check(matches(isDisplayed()));
    }

    public void okPopup() {

        Allure.step("Проверка ссылок");
        Create.okPopup.perform(click());
    }

    public void cancel() {
        Allure.step("Проверка ссылок");
        Create.cancel.perform(click());
        Create.okPopup.perform(click());
    }

    public void checkTitle() {
        Allure.step("Проверка ссылок");
        Create.title.perform(replaceText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent nec pharetra nisl, condimentum ultricies sem."));
        Create.title.check(matches(withText("Lorem ipsum dolor sit amet, consectetur adipiscing")));
    }

    public void openClaim(String time) {
        Allure.step("Открытие заявки");
        onView(allOf(withId(R.id.plan_time_material_text_view), withParent(withParent(allOf(withId(R.id.claim_list_card), withChild(withChild(withText(time)))))))).perform(click());
    }


    public void scrollDown(String title) {
        Allure.step("Скролл до нужной заявки и ее открытие");
        SystemClock.sleep(5000);
        onView(withId(R.id.claim_list_recycler_view)).perform(repeatedlyUntil(swipeDown(), hasDescendant(withText(title)), 10));
        SystemClock.sleep(2000);
        onView(withId(R.id.claim_list_recycler_view)).perform(repeatedlyUntil(swipeUpSlow(), hasDescendant(withText(title)), 10));
        onView(withId(R.id.claim_list_recycler_view)).perform(swipeUpSlow());
        onView(allOf(withId(R.id.executor_name_material_text_view), withParent(withParent(allOf(withId(R.id.claim_list_card), withChild(withChild(withText(title)))))))).perform(click());
    }

    public void fillClaimAndCheckFields(String date, String time, String title, String description) {
        SystemClock.sleep(3000);
        Allure.step("Ввод исполнителя");
        Create.executor.perform(click());
        SystemClock.sleep(3000);
        onData(Matchers.anything())
                .inRoot(RootMatchers.isPlatformPopup())
                .atPosition(1)
                .perform(ViewActions.click());
        Allure.step("Ввод даты");
        Create.date.perform(replaceText(date));
        Allure.step("Ввод времени");
        Create.time.perform(replaceText(time));
        Allure.step("Ввод заголовка");
        Create.title.perform(replaceText(title));
        Allure.step("Ввод описания");
        Create.description.perform(replaceText(description));
        closeSoftKeyboard();
        Allure.step("Проверка даты");
        Create.date.check(matches(withText(date)));
        Allure.step("Проверка времени");
        Create.time.check(matches(withText(time)));
        Allure.step("Проверка заголовка");
        Create.title.check(matches(withText(title)));
        Allure.step("Проверка описания");
        Create.description.check(matches(withText(description)));
        SystemClock.sleep(3000);
    }

    public void scrollUpAndCheck(String title) {
        Allure.step("Скролл вверх для проверки наличия заявки");
        onView(withId(R.id.claim_list_recycler_view)).perform(repeatedlyUntil(swipeDown(), hasDescendant(withText(title)), 10));
    }
}
