package ru.iteco.fmhandroid.uitest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentDate;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentTime;

import android.os.SystemClock;

import androidx.recyclerview.widget.RecyclerView;
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

@RunWith(AllureAndroidJUnit4.class)

public class MainTest {
    AuthStep Auth = new AuthStep();
    MainStep Main = new MainStep();
    CreateClaimStep Claim = new CreateClaimStep();
    FilterStep Filter = new FilterStep();
    ClaimsStep ClaimScreen = new ClaimsStep();

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
        SystemClock.sleep(3000);
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
        Claim.onScreen();
        Claim.fillClaimAndCheckFields(date, time, title, description);
        Claim.save();
        Main.openAllClaims();
        ClaimScreen.filter();
        Filter.openCheck();
        Filter.applyClaims();
        SystemClock.sleep(5000);
        Allure.step("Скролл вниз");
        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.claim_list_recycler_view);
        onView(withId(R.id.claim_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(recyclerView.getAdapter().getItemCount() - 1));
        SystemClock.sleep(5000);
        Claim.scrollUpAndCheck(title);
    }
}
