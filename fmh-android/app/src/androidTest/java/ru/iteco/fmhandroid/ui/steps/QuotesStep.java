package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.not;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.QuoteElements;

public class QuotesStep {
    QuoteElements Quotes = new QuoteElements();

    public void onScreen() {
        Allure.step("Нахождение в окне цитат");
        Quotes.screen.check(matches(isDisplayed()));
    }

    public void expand() {
        Allure.step("Разворачивание цитаты");
        Quotes.title.perform(click());
        Quotes.description.check(matches(isDisplayed()));
    }

    public void collapse() {
        Allure.step("Сворачивание цитаты");
        Quotes.titleCollapse.perform(click());
        Quotes.descriptionCollapse.check(matches(not(isDisplayed())));
    }
}
