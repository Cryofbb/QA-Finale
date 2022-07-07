package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.utils.Utils.isDisplayedWithSwipe;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.ClaimsElements;

public class ClaimsStep {
    ClaimsElements Claims = new ClaimsElements();

    public void onScreen() {
        Allure.step("Проверка ссылок");
        Claims.screen.check(matches(isDisplayed()));
    }

    public void open() {
        Allure.step("Открытие заявки");
        Claims.openClaim.perform(click());
    }

    public void goBack() {
        Allure.step("Возврат из открытой заявки");
        Claims.closeClaim.perform(click());
    }

    public void addNew() {
        Allure.step("Нажатие на кнопку добавления заявки");
        Claims.addNew.perform(click());
    }

    public void filter() {
        Allure.step("Открытие фильтра");
        Claims.openFilter.perform(click());
    }

    public void clickTime(String time) {
        Claims.time.check(matches(withText(time))).perform(click());
    }

    public void checkIsDisplayed(String title) {
        if (isDisplayedWithSwipe(onView(withText(title)), 1, true)) {
            onView(withText(title)).check(matches(isDisplayed()));
        }
    }
}
