package ru.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.fmhandroid.utils.Utils.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsScreen {
    public ViewInteraction news = onView(withText("News"));
    public ViewInteraction editNewsButton = onView(withId(R.id.edit_news_material_button));
    public ViewInteraction newsTitle = onView(withIndex(withId(R.id.news_item_title_text_view), 0));
    public ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));
    public ViewInteraction deleteNewsButton = onView(withIndex(withId(R.id.delete_news_item_image_view), 0));
    public ViewInteraction editSingleNewsButton = onView(withId(R.id.edit_news_item_image_view));
    public ViewInteraction collapseNewsEditButton = onView(withId(R.id.view_news_item_image_view));
    public ViewInteraction statusNewsEditButton = onView(withId(R.id.news_item_published_text_view));
    public ViewInteraction categoryNewsEditButton = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction titleNewsEditButton = onView(withId(R.id.news_item_title_text_input_edit_text));
    public ViewInteraction dateNewsEditButton = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public ViewInteraction timeNewsEditButton = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public ViewInteraction descriptionNewsEditButton = onView(withId(R.id.news_item_description_text_input_edit_text));
}
