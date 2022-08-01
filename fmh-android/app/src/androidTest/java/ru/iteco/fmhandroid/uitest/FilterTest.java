package ru.iteco.fmhandroid.uitest;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static ru.iteco.fmhandroid.ui.utils.Utils.checkClaimStatus;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentDate;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentTime;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.SystemClock;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.ClaimsStep;
import ru.iteco.fmhandroid.ui.steps.CreateNewsStep;
import ru.iteco.fmhandroid.ui.steps.FilterStep;
import ru.iteco.fmhandroid.ui.steps.MainStep;
import ru.iteco.fmhandroid.ui.steps.MenuStep;
import ru.iteco.fmhandroid.ui.steps.NewsStep;

@RunWith(AllureAndroidJUnit4.class)

public class FilterTest {
    AuthStep Auth = new AuthStep();
    MenuStep Menu = new MenuStep();
    FilterStep Filter = new FilterStep();
    ClaimsStep ClaimScreen = new ClaimsStep();
    NewsStep NewsStep = new NewsStep();
    CreateNewsStep Edit = new CreateNewsStep();
    String date = getCurrentDate();
    String time = getCurrentTime();
    MainStep Main = new MainStep();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        SystemClock.sleep(5000);
        try {
            Main.onScreen();
        } catch (NoMatchingViewException e) {
            Auth.validAuth();
        }
        SystemClock.sleep(5000);
    }

    @Test
    @DisplayName("Фильтрация новостей из главного окна")
    public void filterNews() {
        Menu.openNews();
        NewsStep.edit();
        Edit.add();
        Edit.fillNewsAndCheckFields(date, time, time, date);
        Edit.saveButton();
        Menu.openNews();
        NewsStep.filter();
        Filter.onScreenNews();
        Filter.dateStart(date);
        Filter.dateEnd(date);
        Filter.apply();
        NewsStep.checkDate(date);
        NewsStep.edit();
        Edit.deleteWithTitle(time);
    }

    @Test
    @DisplayName("Фильтрация новостей из окна редактирования")
    public void filterEditNews() {
        Menu.openNews();
        NewsStep.edit();
        Edit.add();
        Edit.fillNewsAndCheckFields(date, time, time, date);
        Edit.saveButton();
        NewsStep.filter();
        Filter.onScreenNews();
        Filter.dateStart(date);
        Filter.dateEnd(date);
        Filter.apply();
        Edit.checkDate(date);
        Edit.deleteWithTitle(time);
    }

    @Test
    @DisplayName("Сортировка новостей")
    public void sortNews() {
        Menu.openNews();
        String start = NewsStep.getTitle();
        NewsStep.sort();
        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.news_list_recycler_view);
        onView(withId(R.id.news_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(0));
        SystemClock.sleep(3000);

        NewsStep.checkUnmatched(start);
        NewsStep.sort();

        onView(withId(R.id.news_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(0));
        SystemClock.sleep(3000);

        NewsStep.checkMatched(start);
    }

    @Test
    @DisplayName("Сортировка новостей в меню редактирования")
    public void sortEditNews() {
        Menu.openNews();
        NewsStep.edit();
        Edit.add();
        Edit.fillNewsAndCheckFields(date, time, time, date);
        Edit.saveButton();
        String start = NewsStep.getTitle();
        NewsStep.sort();
        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.news_list_recycler_view);
        onView(withId(R.id.news_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(0));
        SystemClock.sleep(3000);
        NewsStep.checkUnmatched(start);
        NewsStep.sort();
        onView(withId(R.id.news_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(0));
        SystemClock.sleep(3000);
        NewsStep.checkMatched(start);
        Edit.deleteWithTitle(time);
    }

    @Test
    @DisplayName("Фильтрация заявок. Открытые")
    public void filterClaimOpen() {
        Menu.openClaims();
        ClaimScreen.filter();
        Filter.onScreenClaims();
        Filter.inProgressCheck();
        Filter.applyClaims();
        checkClaimStatus("Open");
    }

    @Test
    @DisplayName("Фильтрация заявок. В работе")
    public void filterClaimInProgress() {
        Menu.openClaims();
        ClaimScreen.filter();
        Filter.onScreenClaims();
        Filter.openCheck();
        Filter.applyClaims();
        checkClaimStatus("In progress");
    }

    @Test
    @DisplayName("Фильтрация заявок. Закрытые")
    public void filterClaimExecuted() {
        Menu.openClaims();
        ClaimScreen.filter();
        Filter.onScreenClaims();
        Filter.openCheck();
        Filter.inProgressCheck();
        Filter.executedCheck();
        Filter.applyClaims();
        checkClaimStatus("Executed");
    }

    @Test
    @DisplayName("Фильтрация заявок. Отмененные")
    public void filterClaimCanceled() {
        Menu.openClaims();
        ClaimScreen.filter();
        Filter.onScreenClaims();
        Filter.openCheck();
        Filter.inProgressCheck();
        Filter.cancelledCheck();
        Filter.applyClaims();
        checkClaimStatus("Canceled");
    }

}