package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.repeatedlyUntil;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static ru.iteco.fmhandroid.ui.utils.Utils.checkClaimStatus;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentDate;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentTime;

import android.os.Environment;
import android.os.SystemClock;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screens.AuthScreen;
import ru.iteco.fmhandroid.ui.screens.ClaimsScreen;
import ru.iteco.fmhandroid.ui.screens.CreateClaimScreen;
import ru.iteco.fmhandroid.ui.screens.EditingNewsScreen;
import ru.iteco.fmhandroid.ui.screens.FilterClaimsScreen;
import ru.iteco.fmhandroid.ui.screens.FilterNewsScreen;
import ru.iteco.fmhandroid.ui.screens.MainScreen;
import ru.iteco.fmhandroid.ui.screens.MenuScreen;
import ru.iteco.fmhandroid.ui.screens.NewsScreen;
import ru.iteco.fmhandroid.utils.Utils;

@RunWith(AllureAndroidJUnit4.class)

public class FilterTest {
    AuthScreen Auth = new AuthScreen();
    MenuScreen Menu = new MenuScreen();
    MainScreen Main = new MainScreen();
    CreateClaimScreen Claim = new CreateClaimScreen();
    FilterClaimsScreen FilterClaim = new FilterClaimsScreen();
    ClaimsScreen ClaimScreen = new ClaimsScreen();
    FilterNewsScreen FilterNews = new FilterNewsScreen();
    NewsScreen NewsScreen = new NewsScreen();
    EditingNewsScreen Edit = new EditingNewsScreen();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Before
    public void createAllureDir() {
        File path = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/allure-results/"
        );
        if (!path.exists()) {
            path.mkdirs();
        }
    }

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

    String date = getCurrentDate();
    String time = getCurrentTime();

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
        FilterNews.dateStart(date);
        FilterNews.dateEnd(date);
        FilterNews.apply();
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
        FilterNews.dateStart(date);
        FilterNews.dateEnd(date);
        FilterNews.apply();
        Edit.checkDate(date);
        Edit.deleteWithTitle(time);
    }

    @Test
    @DisplayName("Сортировка новостей")
    public void sortNews() {
        Menu.openNews();
        String newsStartTitle = NewsScreen.getTitle();
        NewsScreen.sort();
        String newsEndTitle = NewsScreen.getLastTitle();
        NewsScreen.sort();
        onView(withId(R.id.news_list_recycler_view)).perform(swipeDown());
        assertEquals(newsStartTitle, NewsScreen.getTitleAgain());
        assertNotEquals(newsStartTitle, newsEndTitle);
    }
    @Test
    @DisplayName("Сортировка новостей в меню редактирования")
    public void sortEditNews() {
        Menu.openNews();
        NewsScreen.edit();
        String newsStartTitle = NewsScreen.getTitle();
        NewsScreen.sort();
        String newsEndTitle = NewsScreen.getLastTitle();
        NewsScreen.sort();
        assertEquals(newsStartTitle, NewsScreen.getTitleAgain());
        assertNotEquals(newsStartTitle, newsEndTitle);
    }

    @Test
    @DisplayName("Фильтрация заявок. Открытые")
    public void filterClaimOpen() {
        Menu.openClaims();
        ClaimScreen.filter();
        FilterClaim.inProgressCheck();
        FilterClaim.apply();
        checkClaimStatus("Open");
    }

    @Test
    @DisplayName("Фильтрация заявок. В работе")
    public void filterClaimInProgress() {
        Menu.openClaims();
        ClaimScreen.filter();
        FilterClaim.openCheck();
        FilterClaim.apply();
        checkClaimStatus("In progress");
    }

    @Test
    @DisplayName("Фильтрация заявок. Закрытые")
    public void filterClaimExecuted() {
        Menu.openClaims();
        ClaimScreen.filter();
        FilterClaim.openCheck();
        FilterClaim.inProgressCheck();
        FilterClaim.executedCheck();
        FilterClaim.apply();
        checkClaimStatus("Executed");
    }

    @Test
    @DisplayName("Фильтрация заявок. Отмененные")
    public void filterClaimCanceled() {
        Menu.openClaims();
        ClaimScreen.filter();
        FilterClaim.openCheck();
        FilterClaim.inProgressCheck();
        FilterClaim.cancelledCheck();
        FilterClaim.apply();
        checkClaimStatus("Canceled");
    }

}