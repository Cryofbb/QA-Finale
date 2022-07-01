package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentDate;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentTime;

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

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screens.AuthScreen;
import ru.iteco.fmhandroid.ui.screens.ClaimsScreen;
import ru.iteco.fmhandroid.ui.screens.CreateClaimScreen;
import ru.iteco.fmhandroid.ui.screens.FilterScreen;
import ru.iteco.fmhandroid.ui.screens.MenuScreen;
import ru.iteco.fmhandroid.ui.screens.SingleClaimScreen;

@RunWith(AllureAndroidJUnit4.class)

public class ClaimTest {
    AuthScreen Auth = new AuthScreen();
    MenuScreen Menu = new MenuScreen();
    CreateClaimScreen Claim = new CreateClaimScreen();
    FilterScreen Filter = new FilterScreen();
    ClaimsScreen ClaimScreen = new ClaimsScreen();
    SingleClaimScreen SingleClaim = new SingleClaimScreen();
    String title = "Title " + getCurrentTime();
    String title2 = "Title " + getCurrentTime() + " " + getCurrentDate();
    String description = "Description  " + getCurrentDate();
    String date = getCurrentDate();
    String time = getCurrentTime();


    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        SystemClock.sleep(10000);
        try {
            Auth.onScreen();
        } catch (NoMatchingViewException e) {
            Menu.logOut();
        }
        Auth.loginFill("login2");
        Auth.passwordFill("password2");
        Auth.buttonClick();
        SystemClock.sleep(3000);
        Menu.openClaims();
    }

    @After
    public void logOff() {
        Menu.logOut();
    }

    @Test
    @DisplayName("Превышение длины заголовка и ошибки пустых полей")
    public void claimTitleExceed() {
        ClaimScreen.addNew();
        Claim.checkTitle();
        Claim.save();
        Claim.checkEmpty();
        Claim.okPopup();
        Claim.cancel();
    }

    @Test
    @DisplayName("Создание заявки, добавление комментария, дроп, взятие в работу и выполнение заявки")
    public void claimCreate() {
        ClaimScreen.addNew();
        SystemClock.sleep(3000);
        Claim.enterExecutor();
        Claim.enterTitle(title);
        Claim.enterDescription(description);
        Claim.enterDate(date);
        Claim.enterTime(time);
        Espresso.closeSoftKeyboard();
        Claim.save();
        ClaimScreen.filter();
        Filter.openCheck();
        Filter.applyClaims();
        Allure.step("Скрол до конца, поиск заявки");
        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.claim_list_recycler_view);
        onView(withId(R.id.claim_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(recyclerView.getAdapter().getItemCount() - 1));
        Claim.scrollDown(title);
        SingleClaim.addComment(time);
        SingleClaim.checkComment(time);
        SingleClaim.throwOff("Drop");
        SingleClaim.status("Open");
        SingleClaim.editClaim();
        Claim.enterTitle(title2);
        Espresso.closeSoftKeyboard();
        Claim.save();
        onView(withId(R.id.title_text_view)).check(matches(withText(title2)));
        SingleClaim.takeToWork();
        SingleClaim.status("In progress");
        SingleClaim.scrollDown();
        SingleClaim.execute(date);
        SingleClaim.status("Executed");
        SingleClaim.back();
    }

    @Test
    @DisplayName("Отмена заявки")
    public void claimCancel() {
        ClaimScreen.addNew();
        SystemClock.sleep(3000);
        Claim.enterExecutor();
        Claim.enterTitle(title);
        Claim.enterDescription(description);
        Claim.enterDate(date);
        Claim.enterTime(time);
        Espresso.closeSoftKeyboard();
        Claim.save();
        ClaimScreen.filter();
        Filter.openCheck();
        Filter.applyClaims();
        Allure.step("Скрол до конца, поиск заявки");
        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.claim_list_recycler_view);
        onView(withId(R.id.claim_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(recyclerView.getAdapter().getItemCount() - 1));
        Claim.scrollDown(title);
        SingleClaim.throwOff("Drop");
        SingleClaim.status("Open");
        SingleClaim.cancel();
        SingleClaim.status("Canceled");
        SingleClaim.back();
    }
}