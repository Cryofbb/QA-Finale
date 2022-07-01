package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static ru.iteco.fmhandroid.ui.utils.Utils.checkClaimStatus;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentDate;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentTime;

import android.os.SystemClock;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screens.AuthScreen;
import ru.iteco.fmhandroid.ui.screens.ClaimsScreen;
import ru.iteco.fmhandroid.ui.screens.CreateNewsScreen;
import ru.iteco.fmhandroid.ui.screens.FilterScreen;
import ru.iteco.fmhandroid.ui.screens.MenuScreen;
import ru.iteco.fmhandroid.ui.screens.NewsScreen;

@RunWith(AllureAndroidJUnit4.class)

public class FilterTest {
    AuthScreen Auth = new AuthScreen();
    MenuScreen Menu = new MenuScreen();
    FilterScreen Filter = new FilterScreen();
    ClaimsScreen ClaimScreen = new ClaimsScreen();
    NewsScreen NewsScreen = new NewsScreen();
    CreateNewsScreen Edit = new CreateNewsScreen();
    String date = getCurrentDate();
    String time = getCurrentTime();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        SystemClock.sleep(3000);
        try {
            Auth.onScreen();
        } catch (NoMatchingViewException e) {
            Menu.logOut();
        }
        Auth.loginFill("login2");
        Auth.passwordFill("password2");
        Auth.buttonClick();
        SystemClock.sleep(3000);
    }

    @After
    public void logOff() {
        Menu.logOut();
    }

    @Test
    @DisplayName("Фильтрация новостей из главного окна")
    public void filterNews() {
        Menu.openNews();
        NewsScreen.edit();
        Edit.add();
        Edit.categorySelect();
        Edit.enterTitle(time);
        Edit.enterDate(date);
        Edit.enterTime(time);
        Edit.enterDescription(date);
        closeSoftKeyboard();
        Edit.saveButton();
        Menu.openNews();
        NewsScreen.filter();
        Filter.onScreenNews();
        Filter.dateStart(date);
        Filter.dateEnd(date);
        Filter.apply();
        NewsScreen.checkDate(date);
        NewsScreen.edit();
        Edit.deleteWithTitle(time);
    }

    @Test
    @DisplayName("Фильтрация новостей из окна редактирования")
    public void filterEditNews() {
        Menu.openNews();
        NewsScreen.edit();
        Edit.add();
        Edit.categorySelect();
        Edit.enterTitle(time);
        Edit.enterDate(date);
        Edit.enterTime(time);
        Edit.enterDescription(date);
        closeSoftKeyboard();
        Edit.saveButton();
        NewsScreen.filter();
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
        String newsStartTitle = NewsScreen.getTitle();
        NewsScreen.sort();
        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.news_list_recycler_view);
        onView(withId(R.id.news_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(0));
        SystemClock.sleep(3000);
        String newsEndTitle = NewsScreen.getLastTitle();
        NewsScreen.sort();
        onView(withId(R.id.news_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(0));
        SystemClock.sleep(3000);
        assertEquals(newsStartTitle, NewsScreen.getTitleAgain());
        assertNotEquals(newsStartTitle, newsEndTitle);
    }

    @Test
    @DisplayName("Сортировка новостей в меню редактирования")
    public void sortEditNews() {
        Menu.openNews();
        NewsScreen.edit();
        Edit.add();
        Edit.categorySelect();
        Edit.enterTitle(time);
        Edit.enterDate(date);
        Edit.enterTime(time);
        Edit.enterDescription(date);
        closeSoftKeyboard();
        Edit.saveButton();
        String newsStartTitle = NewsScreen.getTitle();
        NewsScreen.sort();
        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.news_list_recycler_view);
        onView(withId(R.id.news_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(0));
        SystemClock.sleep(3000);
        String newsEndTitle = NewsScreen.getLastTitle();
        NewsScreen.sort();
        onView(withId(R.id.news_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(0));
        SystemClock.sleep(3000);
        assertEquals(newsStartTitle, NewsScreen.getTitleAgain());
        assertNotEquals(newsStartTitle, newsEndTitle);
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