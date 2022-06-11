package ru.iteco.fmhandroid.ui;

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
import ru.iteco.fmhandroid.ui.screens.AuthScreen;
import ru.iteco.fmhandroid.ui.screens.ClaimsScreen;
import ru.iteco.fmhandroid.ui.screens.CreateClaimScreen;
import ru.iteco.fmhandroid.ui.screens.FilterClaimsScreen;
import ru.iteco.fmhandroid.ui.screens.MainScreen;
import ru.iteco.fmhandroid.ui.screens.MenuScreen;

@RunWith(AllureAndroidJUnit4.class)

public class ClaimTest {
    AuthScreen Auth = new AuthScreen();
    MenuScreen Menu = new MenuScreen();
    MainScreen Main = new MainScreen();
    CreateClaimScreen Claim = new CreateClaimScreen();
    FilterClaimsScreen Filter = new FilterClaimsScreen();
    ClaimsScreen ClaimScreen = new ClaimsScreen();

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

    @Test
    @DisplayName("Превышение длины заголовка")
    public void claimTitleExceed() {
    }
    @Test
    @DisplayName("Создание заявки")
    public void claimCreate() {
    }
    @Test
    @DisplayName("Написание и правка комментария")
    public void claimComment() {
    }

    @Test
    @DisplayName("Взятие заявки в работу")
    public void claimTakeToWork() {
    }
    @Test
    @DisplayName("Отмена заявки")
    public void claimCancel() {
    }
    @Test
    @DisplayName("Дроп заявки")
    public void claimDrop() {
    }
    @Test
    @DisplayName("Закрытие заявки")
    public void claimClose() {
    }
    @Test
    @DisplayName("Редактирование заявки")
    public void claimEdit() {
    }
}