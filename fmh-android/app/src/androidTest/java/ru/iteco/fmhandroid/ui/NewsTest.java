package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentDate;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentTime;
import static ru.iteco.fmhandroid.ui.utils.Utils.isDisplayedWithSwipe;

import android.os.Environment;
import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
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

@RunWith(AllureAndroidJUnit4.class)

public class NewsTest {
    AuthScreen Auth = new AuthScreen();
    MenuScreen Menu = new MenuScreen();
    MainScreen Main = new MainScreen();
    CreateClaimScreen Claim = new CreateClaimScreen();
    FilterNewsScreen Filter = new FilterNewsScreen();
    ClaimsScreen ClaimScreen = new ClaimsScreen();
    NewsScreen News = new NewsScreen();
    EditingNewsScreen Edit = new EditingNewsScreen();
    String date = getCurrentDate();
    String time = getCurrentTime();
    String title = "Title " + getCurrentTime();
    String description = "Desc" + getCurrentDate();

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
        Main.openAllNews();
    }

    @After
    public void logOff() {
        Menu.logOut();
    }

    @Test
    @DisplayName("Открытие и закрытие новости")
    public void newsOpen() {
        Main.expandSingleNews();
        Main.collapseSingleNews();
    }

    @Test
    @DisplayName("Открытие и закрытие новости в контрольной панели")
    public void newsOpenInPanel() {
        News.edit();
        Edit.expandSingleNews();
        Edit.collapseSingleNews();
    }

    @Test
    @DisplayName("Создание и удаление новости")
    public void newsDelete() {
        News.edit();
        Edit.add();
        Edit.categorySelect();
        Edit.enterTitle(title);
        Edit.enterDate(date);
        Edit.enterTime(time);
        Edit.enterDescription(description);
        closeSoftKeyboard();
        Edit.saveButton();
        Edit.checkIsDisplayed(title);
        Edit.deleteWithTitle(title);
    }

    @Test
    @DisplayName("Редактирование новости")
    public void newsEdit() {
        String newTitle = "New title";
        News.edit();
        Edit.add();
        Edit.categorySelect();
        Edit.enterTitle(title);
        Edit.enterDate(date);
        Edit.enterTime(time);
        Edit.enterDescription(description);
        closeSoftKeyboard();
        Edit.saveButton();
        Edit.checkIsDisplayed(title);
        Edit.edit(title);
        Edit.enterTitle(newTitle);
        closeSoftKeyboard();
        Edit.saveButton();
        Edit.checkIsDisplayed(newTitle);
        Edit.deleteWithTitle(newTitle);
    }

    @Test
    @DisplayName("Изменение статуса новости")
    public void newsStatus() {
        String newTitle = "New title";
        News.edit();
        Edit.add();
        Edit.categorySelect();
        Edit.enterTitle(title);
        Edit.enterDate(date);
        Edit.enterTime(time);
        Edit.enterDescription(description);
        closeSoftKeyboard();
        Edit.saveButton();
        Edit.checkIsDisplayed(title);
        Edit.edit(title);
        Edit.editStatus();
        closeSoftKeyboard();
        Edit.saveButton();
        News.filter();
        Filter.active();
        Filter.apply();
        Edit.checkIsDisplayed(title);
        Edit.deleteWithTitle(title);
    }
}
