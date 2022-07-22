package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.utils.Utils.nestedScrollTo;

import android.os.SystemClock;

import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.MainElements;

public class MainStep {
    MainElements Main = new MainElements();

    public void onScreen() {
        Allure.step("Проверка нахождения на главном экране");
        Main.allNews.check(matches(isDisplayed()));
        Main.allClaims.check(matches(isDisplayed()));
    }

    public void expandAllNews() {
        Allure.step("Раскрытие всех новостей");
        Main.expandAllNews.perform(click());
        Main.allNews.check(matches(isDisplayed()));
    }

    public void expandAllClaims() {
        Allure.step("Раскрытие все заявок");
        Main.expandAllClaims.perform(click());
        Main.addClaim.check(matches(isDisplayed()));
    }

    public void collapseAllNews() {
        Allure.step("Сворачивание всех новостей");
        Main.expandAllNews.perform(click());
        Main.allNews.check(matches(not(isDisplayed())));
    }

    public void collapseAllClaims() {
        Allure.step("Сворачивание все заявок");
        Main.expandAllClaims.perform(click());
        Main.allClaims.check(matches(not(isDisplayed())));
    }

    public void expandSingleNews() {
        Allure.step("Раскрытие новости");
        Main.title.perform(actionOnItemAtPosition(0, click()));
        SystemClock.sleep(3000);
        Main.description.check(matches(isDisplayed()));
    }

    public void collapseSingleNews() {
        Allure.step("Сворачивание новости");
        Main.categoryIcon.perform(click());
        SystemClock.sleep(3000);
        Main.descriptionCollapsed.check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    public void openAllNews() {
        Allure.step("Открытие новостей");
        Main.allNews.perform(click());
        Main.news.check(matches(isDisplayed()));
    }

    public void openAllClaims() {
        Allure.step("Открытие заявок");
        Main.allClaims.perform(click());
        Main.claims.check(matches(isDisplayed()));
    }

    public void addNewClaim() {
        Allure.step("Добавление новой заявки");
        Main.addClaim.perform(click());
    }

    public void openClaim() {
        Allure.step("Открытие заявки");
        Main.executor.perform(click());
        Main.claimStatus.check(matches(isDisplayed()));
    }

    public void backFromClaim() {
        Allure.step("Возвращение в главное окно");
        Main.closeClaim.perform(nestedScrollTo());
        Main.closeClaim.perform(click());
        Main.news.check(matches(isDisplayed()));
    }
}
