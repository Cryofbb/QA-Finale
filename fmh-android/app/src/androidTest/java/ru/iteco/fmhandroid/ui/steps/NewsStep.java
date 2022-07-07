package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.utils.Utils.nestedScrollTo;
import static ru.iteco.fmhandroid.ui.utils.Utils.withIndex;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.NewsElements;
import ru.iteco.fmhandroid.ui.utils.Utils;

public class NewsStep {
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
        return Utils.TextHelpers.getText(News.title2);
    }

    public void checkDate(String text) {
        Allure.step("Проверка даты");
        News.date.check(matches(withText(text)));
    }
    public void scrollUp(){
        News.title.perform(nestedScrollTo())
                .check(matches(isDisplayed()));
    }
    public void checkMatched(String title){
        Allure.step("Проверка соответствия верхнего заголовка изначальному");
        onView(allOf(withIndex(withId(R.id.news_item_title_text_view),0), withId(R.id.news_item_title_text_view))).check(matches(withText(title)));
    }
    public void checkUnmatched(String title){
        Allure.step("Проверка несоответствия верхнего заголовка изначальному");
        onView(allOf(withIndex(withId(R.id.news_item_title_text_view),0), withId(R.id.news_item_title_text_view))).check(matches(not(withText(title))));
    }

}
