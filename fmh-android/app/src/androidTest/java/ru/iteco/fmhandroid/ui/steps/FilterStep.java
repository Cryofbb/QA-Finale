package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.FilterElements;

public class FilterStep {
    FilterElements Filter = new FilterElements();

    public void onScreenClaims() {
        Allure.step("Проверка окна фильтрации заявок");
        Filter.screen.check(matches(isDisplayed()));
    }

    public void openCheck() {
        Allure.step("Нажатие на чекбокс Open");
        Filter.open.perform(click());
    }


    public void inProgressCheck() {
        Allure.step("Нажатие на чекбокс In progress");
        Filter.inProgress.perform(click());
    }


    public void executedCheck() {
        Allure.step("Нажатие на чекбокс Executed");
        Filter.executed.perform(click());
    }


    public void cancelledCheck() {
        Allure.step("Нажатие на чекбокс Canceled");
        Filter.cancelled.perform(click());
    }


    public void applyClaims() {
        Allure.step("Подтверждение фильтра");
        Filter.applyClaims.perform(click());
    }


    public void cancelClaims() {
        Allure.step("Отмена фильтра");
        Filter.cancelClaims.perform(click());
    }

    public void onScreenNews() {
        Allure.step("Проверка окна фильтрации новостей");
        Filter.screenNews.check(matches(isDisplayed()));
    }

    public void filterCategory() {
        Allure.step("Выбор категории");
        Filter.category.perform(click());
        Filter.dateStart.perform(click());
    }

    public void dateStart(String date) {
        Allure.step("Ввод начальной даты публикации");
        Filter.dateStart.perform(replaceText(date));
    }

    public void dateEnd(String date) {
        Allure.step("Ввод конечной даты публикации");
        Filter.dateEnd.perform(replaceText(date));
    }

    public void apply() {
        Allure.step("Подтверждение фильтра");
        Filter.apply.perform(click());
    }

    public void cancel() {
        Allure.step("Отмена фильтра");
        Filter.cancel.perform(click());
    }

    public void active() {
        Allure.step("Выбор активных новостей");
        Filter.active.perform(click());
    }

    public void notActive() {
        Allure.step("Выбор неактивных новостей");
        Filter.notActive.perform(click());
    }
}
