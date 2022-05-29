package ru.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsElements {
    public ViewInteraction screen = onView(withText("News"));
    public ViewInteraction sort = onView(withId(R.id.sort_news_material_button));
    public ViewInteraction filter = onView(withId(R.id.filter_news_material_button));
    public ViewInteraction edit = onView(withId(R.id.edit_news_material_button));
    public ViewInteraction title = onView(withId(R.id.news_item_title_text_view));
    public ViewInteraction description = onView(withId(R.id.news_item_description_text_view));
}
