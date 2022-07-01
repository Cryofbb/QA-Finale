package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.ui.utils.Utils.nestedScrollTo;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.NewsElements;
import ru.iteco.fmhandroid.ui.utils.Utils;

public class NewsScreen {
    NewsElements News = new NewsElements();

    public void onScreen() {
        Allure.step("Нахождение на экране новостей");
        News.screen.check(matches(isDisplayed()));
    }

    public void sort() {
        Allure.step("Нажатие кнопки сортировки");
        News.sort.perform(click());
    }

    public void filter() {
        Allure.step("Нажатие кнопки фильтрации");
        News.filter.perform(click());
    }

    public void edit() {
        Allure.step("Нажатие кнопки редактирования");
        News.edit.perform(click());
    }

    public String getTitle() {
        Allure.step("Получение первого заголовка");
        return Utils.TextHelpers.getText(News.titleWithIndex);
    }

    public String getLastTitle() {
        Allure.step("Получение последнего заголовка");
        return Utils.TextHelpers.getText(News.lastNews);
    }

    public String getTitleAgain() {
        Allure.step("Получение первого заголовка");
        return Utils.TextHelpers.getText(News.firstNews);
    }

    public void checkDate(String text) {
        Allure.step("Проверка даты");
        News.date.check(matches(withText(text)));
    }
    public void scrollUp(){
        News.title.perform(nestedScrollTo())
                .check(matches(isDisplayed()));
    }
}
