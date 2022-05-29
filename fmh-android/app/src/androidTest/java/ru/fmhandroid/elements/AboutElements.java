package ru.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutElements {
    public ViewInteraction title = onView(withId(R.id.about_version_title_text_view));
    public ViewInteraction version = onView(withId(R.id.about_version_value_text_view));
    public ViewInteraction privacy = onView(withId(R.id.about_privacy_policy_value_text_view));
    public ViewInteraction terms = onView(withId(R.id.about_terms_of_use_value_text_view));
    public ViewInteraction back = onView(withId(R.id.about_back_image_button));
}
