package ru.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.fmhandroid.utils.Utils.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QuoteScreen {
    public ViewInteraction quoteScreen = onView(withId(R.id.our_mission_title_text_view));
    public ViewInteraction quoteTitle = onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0));
    public ViewInteraction quoteDescription = onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0));
}
