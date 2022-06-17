package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.utils.Utils.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ClaimsElements {
    public ViewInteraction screen = onView(withText("Claims"));
    public ViewInteraction addNew = onView(withId(R.id.add_new_claim_material_button));
    public ViewInteraction openFilter = onView(withId(R.id.filters_material_button));
    public ViewInteraction closeClaim = onView(withId(R.id.close_image_button));
    public ViewInteraction openClaim = onView(withId(R.id.executor_name_label_material_text_view));
    public ViewInteraction time = onView(withIndex(withId(R.id.plan_time_material_text_view), 0));
}
