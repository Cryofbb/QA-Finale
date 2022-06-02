package ru.iteco.fmhandroid.ui;

import android.os.Environment;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.screens.LoadingScreen;

@RunWith(AllureAndroidJUnit4.class)
public class LoadingTest {
    LoadingScreen Loading = new LoadingScreen();

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

    @Test
    @DisplayName("Проверка элементов загрузки")
    public void loadingElementsTest() {
        Loading.checkLoading();
    }
}
