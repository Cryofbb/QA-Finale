package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.app.Instrumentation;
import android.content.Intent;

import androidx.test.espresso.intent.Intents;

import org.hamcrest.Matcher;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.AboutElements;

public class AboutStep {
    AboutElements About = new AboutElements();

    public void onScreen() {

        Allure.step("Нахождение в окне About");
        About.title.check(matches(isDisplayed()));
    }

    public void checkVersion() {
        Allure.step("Проверка версии");
        About.version.check(matches(allOf(withText("1.0.0"), isDisplayed())));
    }

    public void checkTerms() {
        Allure.step("Проверка terms");
        Intents.init();
        Matcher<Intent> expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData("https://vhospice.org/#/terms-of-use"));
        intending(expectedIntent).respondWith(new Instrumentation.ActivityResult(0, null));
        About.terms.perform(click());
        intended(expectedIntent);
        Intents.release();
    }

    public void checkPrivacy() {
        Allure.step("Проверка privacy");
        Intents.init();
        Matcher<Intent> expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData("https://vhospice.org/#/privacy-policy/"));
        intending(expectedIntent).respondWith(new Instrumentation.ActivityResult(0, null));
        About.privacy.perform(click());
        intended(expectedIntent);
        Intents.release();
    }

    public void backButton() {
        Allure.step("Возврат назад");
        About.back.perform(click());
    }
}
