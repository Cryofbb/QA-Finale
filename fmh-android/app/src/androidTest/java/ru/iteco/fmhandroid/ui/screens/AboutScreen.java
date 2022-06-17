package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.AboutElements;

public class AboutScreen {
    AboutElements About = new AboutElements();

    public void onScreen() {

        Allure.step("Нахождение в окне About");
        About.title.check(matches(isDisplayed()));
    }

    public void checkVersion() {
        Allure.step("Проверка версии");
        About.version.check(matches(allOf(withText("1.0.0"), isDisplayed())));
    }

    public void checkLinks() {
        Allure.step("Проверка ссылок");
        About.terms.check(matches(allOf(withText("https://vhospice.org/#/terms-of-use"), isDisplayed(), isClickable())));
        About.privacy.check(matches(allOf(withText("https://vhospice.org/#/privacy-policy/"), isDisplayed(), isClickable())));
    }

    public void backButton() {
        Allure.step("Возврат назад");
        About.back.perform(click());
    }
}
