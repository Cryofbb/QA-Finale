package ru.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class EditClaimElements {
    public ViewInteraction screen = onView(withText("Editing"));
    public ViewInteraction subscreen = onView(withText("Claims"));
    public ViewInteraction title = onView(withId(R.id.title_edit_text));
    public ViewInteraction executor = onView(withId(R.id.executor_drop_menu_auto_complete_text_view));
    public ViewInteraction date = onView(withId(R.id.date_in_plan_text_input_edit_text));
    public ViewInteraction time = onView(withId(R.id.time_in_plan_text_input_edit_text));
    public ViewInteraction description = onView(withId(R.id.description_edit_text));
    public ViewInteraction save = onView(withId(R.id.save_button));
    public ViewInteraction cancel = onView(withId(R.id.cancel_button));
    public ViewInteraction okPopup = onView(withText("OK"));
    public ViewInteraction cancelPopup = onView(withText("CANCEL"));
    public ViewInteraction emptyFieldsWarning = onView(withText("Fill empty fields"));
}
