package ru.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class SingleClaimElements {
    public ViewInteraction title = onView(withId(R.id.title_text_view));
    public ViewInteraction editScreen = onView(withText("Editing"));
    public ViewInteraction executor = onView(withId(R.id.executor_name_text_view));
    public ViewInteraction date = onView(withId(R.id.plane_date_text_view));
    public ViewInteraction time = onView(withId(R.id.plan_time_text_view));
    public ViewInteraction status = onView(withId(R.id.status_label_text_view));
    public ViewInteraction description = onView(withId(R.id.description_text_view));
    public ViewInteraction author = onView(withId(R.id.author_name_text_view));
    public ViewInteraction editComment = onView(withId(R.id.edit_comment_image_button));
    public ViewInteraction addComment = onView(withId(R.id.add_comment_image_button));
    public ViewInteraction processing = onView(withId(R.id.status_processing_image_button));
    public ViewInteraction takeToWork = onView(withText("take to work"));
    public ViewInteraction toExecute = onView(withText("To execute"));
    public ViewInteraction throwOff = onView(withText("Throw off"));
    public ViewInteraction editClaim = onView(withId(R.id.edit_processing_image_button));
    public ViewInteraction commentField = onView(withId(R.id.editText));
    public ViewInteraction okPopup = onView(withText("OK"));
    public ViewInteraction cancelPopup = onView(withText("CANCEL"));
    public ViewInteraction save = onView(withId(R.id.save_button));
    public ViewInteraction cancel = onView(withId(R.id.cancel_button));
    public ViewInteraction back = onView(withId(R.id.close_image_button));
}
