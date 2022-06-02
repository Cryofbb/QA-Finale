package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class FilterNewsElements {
    public ViewInteraction screen = onView(withId(R.id.filter_news_title_text_view));
    public ViewInteraction category = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction dateStart = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public ViewInteraction dateEnd = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public ViewInteraction apply = onView(withId(R.id.filter_button));
    public ViewInteraction cancel = onView(withId(R.id.cancel_button));
}
