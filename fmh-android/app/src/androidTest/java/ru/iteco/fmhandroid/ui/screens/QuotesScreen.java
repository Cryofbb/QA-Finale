package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

import ru.iteco.fmhandroid.ui.elements.QuoteElements;

public class QuotesScreen {
    QuoteElements Quotes = new QuoteElements();

    public void onScreen() {
        Quotes.screen.check(matches(isDisplayed()));
    }

    public void expand() {
        Quotes.title.perform(click());
        Quotes.description.check(matches(isDisplayed()));
    }

    public void collapse() {
        Quotes.titleCollapse.perform(click());
        Quotes.descriptionCollapse.check(matches(not(isDisplayed())));
    }
}
