package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.NewsElements;
import ru.iteco.fmhandroid.ui.utils.Utils;

public class NewsScreen {
    NewsElements News = new NewsElements();

    public void onScreen() {
        News.screen.check(matches(isDisplayed()));
    }

    public void sort() {
        News.sort.perform(click());
    }

    public void filter() {
        News.filter.perform(click());
    }

    public void edit() {
        News.edit.perform(click());
    }

    public void collapse() {
        News.titleWithIndex.perform(click());
        News.descCollapsed.check(matches(not(isDisplayed())));
    }

    public void expand() {
        News.titleWithIndex.perform(click());
        News.description.check(matches(isDisplayed()));
    }
    public String getTitle() {
        return Utils.TextHelpers.getText(News.titleWithIndex);
    }

    public String getLastTitle() {
        return Utils.TextHelpers.getText(News.lastNews);
    }

    public String getTitleAgain() {
        return Utils.TextHelpers.getText(News.firstNews);
    }
    public void checkDate(String text) {
        News.date.check(matches(withText(text)));
    }

}
