package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.LoadingElements;

public class LoadingScreen {
    LoadingElements Loading = new LoadingElements();

    public void checkLoading() {
        Allure.step("Проверка отображения элементов загрузки");
        Loading.splashScreen.check(matches(isDisplayed()));
        Loading.splashText.check(matches(isDisplayed()));
    }
}
