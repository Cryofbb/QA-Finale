package ru.fmhandroid.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.not;

import ru.fmhandroid.elements.NewsElements;

public class NewsScreen {
    NewsElements News = new NewsElements();

    public void onNewsScreen() {
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
        News.title.perform(click());
        News.description.check(matches(not(isDisplayed())));
    }

    public void expand() {
        News.title.perform(click());
        News.description.check(matches(isDisplayed()));
    }
}
