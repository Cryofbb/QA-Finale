package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class FilterClaimsElements {
    public ViewInteraction screen = onView(withId(R.id.claim_filter_dialog_title));
    public ViewInteraction open = onView(withId(R.id.item_filter_open));
    public ViewInteraction inProgress = onView(withId(R.id.item_filter_in_progress));
    public ViewInteraction executed = onView(withId(R.id.item_filter_executed));
    public ViewInteraction cancelled = onView(withId(R.id.item_filter_cancelled));
    public ViewInteraction apply = onView(withId(R.id.claim_list_filter_ok_material_button));
    public ViewInteraction cancel = onView(withId(R.id.claim_filter_cancel_material_button));
}
