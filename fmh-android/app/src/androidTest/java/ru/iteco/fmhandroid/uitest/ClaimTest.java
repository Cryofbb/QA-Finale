package ru.iteco.fmhandroid.uitest;

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
import ru.iteco.fmhandroid.ui.steps.CreateClaimStep;
import ru.iteco.fmhandroid.ui.steps.FilterStep;
import ru.iteco.fmhandroid.ui.steps.MainStep;
import ru.iteco.fmhandroid.ui.steps.MenuStep;
import ru.iteco.fmhandroid.ui.steps.SingleClaimStep;

@RunWith(AllureAndroidJUnit4.class)

public class ClaimTest {
    AuthStep Auth = new AuthStep();
    MenuStep Menu = new MenuStep();
    MainStep Main = new MainStep();
    CreateClaimStep Claim = new CreateClaimStep();
    FilterStep Filter = new FilterStep();
    ClaimsStep ClaimScreen = new ClaimsStep();
    SingleClaimStep SingleClaim = new SingleClaimStep();
    String title = "Title " + getCurrentTime();
    String title2 = "Title " + getCurrentTime() + " " + getCurrentDate();
    String description = "Description  " + getCurrentDate();
    String date = getCurrentDate();
    String time = getCurrentTime();


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
        Menu.openClaims();
    }

    @Test
    @DisplayName("Превышение длины заголовка и ошибки пустых полей")
    public void claimTitleExceed() {
        ClaimScreen.addNew();
        SystemClock.sleep(5000);
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
        Claim.fillClaimAndCheckFields(date, time, title, description);
        Claim.save();
        ClaimScreen.filter();
        Filter.openCheck();
        Filter.applyClaims();
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
        SingleClaim.checkTitle(title2);
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
        Claim.fillClaimAndCheckFields(date, time, "Заголовок " + title, description);
        Claim.save();
        ClaimScreen.filter();
        Filter.openCheck();
        Filter.applyClaims();
        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.claim_list_recycler_view);
        onView(withId(R.id.claim_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(recyclerView.getAdapter().getItemCount() - 1));
        Claim.scrollDown("Заголовок " + title);
        SingleClaim.throwOff("Drop");
        SingleClaim.status("Open");
        SingleClaim.cancel();
        SingleClaim.status("Canceled");
        SingleClaim.back();
    }
}