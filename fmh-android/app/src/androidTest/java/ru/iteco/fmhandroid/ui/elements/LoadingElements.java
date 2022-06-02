package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class LoadingElements {
    public ViewInteraction splashScreen = onView(withId(R.id.splash_screen_circular_progress_indicator));
    public ViewInteraction splashText = onView(withId(R.id.splashscreen_text_view));
}
