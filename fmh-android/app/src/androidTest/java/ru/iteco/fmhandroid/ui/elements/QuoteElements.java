package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.Utils.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QuoteElements {
    public ViewInteraction screen = onView(withId(R.id.our_mission_title_text_view));
    public ViewInteraction description = onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0));
    public ViewInteraction title = onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0));
    public ViewInteraction titleCollapse = onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0));
    public ViewInteraction descriptionCollapse = onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0));
}
