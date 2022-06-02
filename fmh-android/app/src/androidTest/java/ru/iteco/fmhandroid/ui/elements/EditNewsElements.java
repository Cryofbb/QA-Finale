package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class EditNewsElements {
    public ViewInteraction screen = onView(withText("Control panel"));
    public ViewInteraction creating = onView(withText("Creating"));
    public ViewInteraction editing = onView(withText("Editing"));
    public ViewInteraction addNew = onView(withId(R.id.add_news_image_view));
    public ViewInteraction delete = onView(withId(R.id.delete_news_item_image_view));
    public ViewInteraction edit = onView(withId(R.id.edit_news_item_image_view));
    public ViewInteraction expand = onView(withId(R.id.view_news_item_image_view));
    public ViewInteraction title = onView(withId(R.id.news_item_title_text_view));
    public ViewInteraction status = onView(withId(R.id.news_item_published_text_view));
    public ViewInteraction description = onView(withId(R.id.news_item_description_text_view));
    public ViewInteraction editCategory = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction editTitle = onView(withId(R.id.news_item_title_text_input_edit_text));
    public ViewInteraction editDate = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public ViewInteraction editTime = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public ViewInteraction editDescription = onView(withId(R.id.news_item_description_text_input_edit_text));
    public ViewInteraction editStatus = onView(withId(R.id.switcher));
    public ViewInteraction save = onView(withId(R.id.save_button));
    public ViewInteraction cancel = onView(withId(R.id.cancel_button));
    public ViewInteraction okPopup = onView(withText("OK"));
    public ViewInteraction cancelPopup = onView(withText("CANCEL"));
    public ViewInteraction emptyFieldsWarning = onView(withText("Fill empty fields"));
    public ViewInteraction checkboxActive = onView(withId(R.id.filter_news_active_material_check_box));
    public ViewInteraction checkboxNotActive = onView(withId(R.id.filter_news_inactive_material_check_box));
}
