package ru.iteco.fmhandroid.uitest;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentDate;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentTime;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.CreateNewsStep;
import ru.iteco.fmhandroid.ui.steps.FilterStep;
import ru.iteco.fmhandroid.ui.steps.MainStep;
import ru.iteco.fmhandroid.ui.steps.NewsStep;

@RunWith(AllureAndroidJUnit4.class)

public class NewsTest {
    AuthStep Auth = new AuthStep();
    MainStep Main = new MainStep();
    FilterStep Filter = new FilterStep();
    NewsStep News = new NewsStep();
    CreateNewsStep Edit = new CreateNewsStep();
    String date = getCurrentDate();
    String time = getCurrentTime();
    String title = "Title " + getCurrentTime();
    String description = "Desc" + getCurrentDate();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        SystemClock.sleep(3000);
        try {
            Main.onScreen();
        } catch (NoMatchingViewException e) {
            Auth.validAuth();
        }
        Main.openAllNews();
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
        SystemClock.sleep(3000);
        Edit.collapseSingleNews();
    }

    @Test
    @DisplayName("Создание и удаление новости")
    public void newsDelete() {
        News.edit();
        Edit.add();
        Edit.fillNewsAndCheckFields(date, time, title, description);
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
        Edit.fillNewsAndCheckFields(date, time, title, description);
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
        Edit.fillNewsAndCheckFields(date, time, title, description);
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
