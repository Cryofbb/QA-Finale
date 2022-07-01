package ru.iteco.fmhandroid.ui;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.screens.LoadingScreen;

@RunWith(AllureAndroidJUnit4.class)
public class LoadingTest {
    LoadingScreen Loading = new LoadingScreen();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Проверка элементов загрузки")
    public void loadingElementsTest() {
        Loading.checkLoading();
    }
}
