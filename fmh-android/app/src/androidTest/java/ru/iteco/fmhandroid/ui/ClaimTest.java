package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentDate;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentTime;

import android.os.Environment;
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

import java.io.File;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.SingleClaimElements;
import ru.iteco.fmhandroid.ui.screens.AuthScreen;
import ru.iteco.fmhandroid.ui.screens.ClaimsScreen;
import ru.iteco.fmhandroid.ui.screens.CreateClaimScreen;
import ru.iteco.fmhandroid.ui.screens.FilterScreen;
import ru.iteco.fmhandroid.ui.screens.MainScreen;
import ru.iteco.fmhandroid.ui.screens.MenuScreen;
import ru.iteco.fmhandroid.ui.screens.SingleClaimScreen;

@RunWith(AllureAndroidJUnit4.class)

public class ClaimTest {
    AuthScreen Auth = new AuthScreen();
    MenuScreen Menu = new MenuScreen();
    MainScreen Main = new MainScreen();
    CreateClaimScreen Claim = new CreateClaimScreen();
    FilterScreen Filter = new FilterScreen();
    ClaimsScreen ClaimScreen = new ClaimsScreen();
    SingleClaimScreen SingleClaim = new SingleClaimScreen();
    String title = "Title " + getCurrentTime();
    String title2 = "Title " + getCurrentTime() + " " + getCurrentDate();
    String description = "Description  " + getCurrentDate();
    String date = getCurrentDate();
    String time = getCurrentTime();
    String executor = "Лебедев Данил Александрович";
    SingleClaimElements Elem = new SingleClaimElements();

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

//    @After
//    public void logOff() {
//        Menu.logOut();
//    }

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
    @DisplayName("Создание заявки")
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
        Filter.apply();
        //Скрол до конца
        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.claim_list_recycler_view);
        onView(withId(R.id.claim_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(recyclerView.getAdapter().getItemCount() - 1));
        Claim.scrollDown(title);






    }
    @Test
    @DisplayName("Написание и правка комментария")
    public void claimComment() {
        SingleClaim.cancel();
        SingleClaim.status("Canceled");
    }

    @Test
    @DisplayName("Взятие заявки в работу")
    public void claimTakeToWork() {
        ClaimScreen.filter();
        Filter.inProgressCheck();
        //Filter.openCheck();
        Filter.apply();
        //RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.claim_list_recycler_view);
        //onView(withId(R.id.claim_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(recyclerView.getAdapter().getItemCount() - 1));
        Claim.scrollDown("Title 15:35");
        //SingleClaim.status("In progress");
        //SingleClaim.throwOff(time);
        //SingleClaim.status("Open");
        SingleClaim.addComment(time);


        //SingleClaim.fillComment(time);
//        SingleClaim.checkComment(time);
//
//
//
//

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
        ClaimScreen.filter();
        Filter.inProgressCheck();
        Filter.apply();
        SystemClock.sleep(5000);
        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.claim_list_recycler_view);
        onView(withId(R.id.claim_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(recyclerView.getAdapter().getItemCount() - 1));
        SystemClock.sleep(5000);
        Claim.scrollDown("Title 15:35");
        SingleClaim.addComment(time);
        SingleClaim.checkComment(time);
        SystemClock.sleep(2000);
        SingleClaim.editComment(time);
        SingleClaim.fillComment("date");
        SingleClaim.checkComment("date");
        SingleClaim.editClaim();
        Claim.enterTitle(title2);
        onView(withId(R.id.title_text_view)).check(matches(withText(title2)));
        SingleClaim.takeToWork();
        SingleClaim.status("In progress");
        SingleClaim.execute(date);
        SingleClaim.status("Executed");
        SingleClaim.back();
    }
}