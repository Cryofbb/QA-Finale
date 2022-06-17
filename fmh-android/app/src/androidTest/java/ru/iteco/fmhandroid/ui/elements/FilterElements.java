package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class FilterElements {
    public ViewInteraction screen = onView(withId(R.id.claim_filter_dialog_title));
    public ViewInteraction open = onView(withId(R.id.item_filter_open));
    public ViewInteraction inProgress = onView(withId(R.id.item_filter_in_progress));
    public ViewInteraction executed = onView(withId(R.id.item_filter_executed));
    public ViewInteraction cancelled = onView(withId(R.id.item_filter_cancelled));
    public ViewInteraction applyClaims = onView(withId(R.id.claim_list_filter_ok_material_button));
    public ViewInteraction cancelClaims = onView(withId(R.id.claim_filter_cancel_material_button));
    public ViewInteraction screenNews = onView(withId(R.id.filter_news_title_text_view));

    public ViewInteraction category = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction dateStart = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public ViewInteraction dateEnd = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public ViewInteraction apply = onView(withId(R.id.filter_button));
    public ViewInteraction cancel = onView(withId(R.id.cancel_button));
    public ViewInteraction active = onView(withId(R.id.filter_news_active_material_check_box));
    public ViewInteraction notActive = onView(withId(R.id.filter_news_inactive_material_check_box));
}
