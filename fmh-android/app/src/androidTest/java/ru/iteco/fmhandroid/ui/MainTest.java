package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.repeatedlyUntil;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
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
import ru.iteco.fmhandroid.ui.screens.FilterClaimsScreen;
import ru.iteco.fmhandroid.ui.screens.MainScreen;
import ru.iteco.fmhandroid.ui.screens.MenuScreen;

@RunWith(AllureAndroidJUnit4.class)

public class MainTest {
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
    @DisplayName("Сворачивание и разворачивание раздела новостей")
    public void expandNews() {
        Main.collapseAllNews();
        Main.expandAllNews();
    }

    @Test
    @DisplayName("Сворачивание и разворачивание раздела заявок")
    public void expandClaims() {
        Main.collapseAllClaims();
        Main.expandAllClaims();
    }

    @Test
    @DisplayName("Переход в раздел новостей с главной страницы")
    public void allNews() {
        Main.openAllNews();
    }

    @Test
    @DisplayName("Переход в раздел заявок с главной страницы")
    public void allClaims() {
        Main.openAllClaims();
    }

    @Test
    @DisplayName("Разворачивание и сворачивание одиночной новости")
    public void expandSingleNews() {
        Main.expandSingleNews();
        Main.collapseSingleNews();
    }

    @Test
    @DisplayName("Открытие заявки и возврат из нее на главную страницу")
    public void openClaim() {
        Main.openClaim();
        SystemClock.sleep(3000);
        Main.backFromClaim();
    }

    @Test
    @DisplayName("Добавление заявки с главной страницы")
    public void addClaim() {
        String title = "Title " + getCurrentDate() + " " + getCurrentTime();
        String description = "Description  " + getCurrentDate();
        String date = getCurrentDate();
        String time = getCurrentTime();
        Main.addNewClaim();
        SystemClock.sleep(3000);
        Claim.onScreen();
        Claim.enterExecutor();
        Claim.enterTitle(title);
        Claim.enterDescription(description);
        Claim.enterDate(date);
        Claim.enterTime(time);
        Espresso.closeSoftKeyboard();
        Claim.save();
        Main.openAllClaims();
        ClaimScreen.filter();
        Filter.openCheck();
        Filter.apply();
        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.claim_list_recycler_view);
        onView(withId(R.id.claim_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(recyclerView.getAdapter().getItemCount() - 1));
        SystemClock.sleep(5000);
        onView(withId(R.id.claim_list_recycler_view)).perform(repeatedlyUntil(swipeDown(), hasDescendant(withText(title)), 10));
    }
}
