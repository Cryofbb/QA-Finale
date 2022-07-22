package ru.iteco.fmhandroid.uitest;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.LoadingStep;

@RunWith(AllureAndroidJUnit4.class)
public class LoadingTest {
    LoadingStep Loading = new LoadingStep();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Проверка элементов загрузки")
    public void loadingElementsTest() {
        Loading.checkLoading();
    }
}
