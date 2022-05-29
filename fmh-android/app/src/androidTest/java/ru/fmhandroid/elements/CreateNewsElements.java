package ru.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class CreateNewsElements {
    public ViewInteraction screen = onView(withText("Creating"));
    public ViewInteraction subscreen = onView(withText("News"));
    public ViewInteraction category = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction title = onView(withId(R.id.news_item_title_text_input_edit_text));
    public ViewInteraction date = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public ViewInteraction time = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public ViewInteraction description = onView(withId(R.id.news_item_description_text_input_edit_text));
    public ViewInteraction save = onView(withId(R.id.save_button));
    public ViewInteraction cancel = onView(withId(R.id.cancel_button));
    public ViewInteraction okPopup = onView(withText("OK"));
    public ViewInteraction cancelPopup = onView(withText("CANCEL"));
    public ViewInteraction emptyFieldsWarning = onView(withText("Fill empty fields"));
}
