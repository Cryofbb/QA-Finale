package ru.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutScreen {
    public ViewInteraction aboutAppVersion = onView(withId(R.id.about_version_value_text_view));
    public ViewInteraction aboutAppPrivacy = onView(withId(R.id.about_privacy_policy_value_text_view));
    public ViewInteraction aboutAppTerms = onView(withId(R.id.about_terms_of_use_value_text_view));
    public ViewInteraction aboutAppBackButton = onView(withId(R.id.about_back_image_button));
}
