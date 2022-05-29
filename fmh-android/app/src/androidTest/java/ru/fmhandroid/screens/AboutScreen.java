package ru.fmhandroid.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import ru.fmhandroid.elements.AboutElements;

public class AboutScreen {
    AboutElements About = new AboutElements();
    public void onScreen(){
        About.title.check(matches(isDisplayed()));
    }
    public void checkVersion(){
        About.version.check(matches(allOf(withText("1.0.0"), isDisplayed())));
    }
    public void checkLinks(){
        About.terms.check(matches(allOf(withText("https://vhospice.org/#/terms-of-use"), isDisplayed(), isClickable())));
        About.privacy.check(matches(allOf(withText("https://vhospice.org/#/privacy-policy/"), isDisplayed(), isClickable())));
    }
    public void backButton(){
        About.back.perform(click());
    }
}
