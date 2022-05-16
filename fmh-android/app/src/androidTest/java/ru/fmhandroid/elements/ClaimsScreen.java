package ru.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import static ru.fmhandroid.utils.Utils.withIndex;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class ClaimsScreen {
    public ViewInteraction topicClaims = onView(withIndex(withId(R.id.description_material_text_view), 0));
    public ViewInteraction executorClaims = onView(withIndex(withId(R.id.executor_name_material_text_view), 0));
    public ViewInteraction dateClaims = onView(withIndex(withId(R.id.plan_date_material_text_view), 0));
    public ViewInteraction timeClaims = onView(withIndex(withId(R.id.plan_time_material_text_view), 0));
    public ViewInteraction addNewClaimButton = onView(withId(R.id.add_new_claim_material_button));
    public ViewInteraction descriptionClaimEdit = onView(withId(R.id.description_edit_text));
    public ViewInteraction titleClaimEdit = onView(withId(R.id.title_edit_text));
    public ViewInteraction executorClaimEdit = onView(withId(R.id.executor_drop_menu_auto_complete_text_view));
    public ViewInteraction dateClaimEdit = onView(withId(R.id.date_in_plan_text_input_edit_text));
    public ViewInteraction timeClaimEdit = onView(withId(R.id.time_in_plan_text_input_edit_text));
    public ViewInteraction titleClaim = onView(withId(R.id.title_text_view));
    public ViewInteraction executorClaim = onView(withId(R.id.executor_name_text_view));
    public ViewInteraction descriptionClaim = onView(withId(R.id.description_text_view));
    public ViewInteraction dateClaim = onView(withId(R.id.plane_date_text_view));
    public ViewInteraction timeClaim = onView(withId(R.id.plan_time_text_view));
    public ViewInteraction statusLabelClaim = onView(withId(R.id.status_label_text_view));
    public ViewInteraction addCommentClaim = onView(withId(R.id.add_comment_image_button));
    public ViewInteraction commentFieldClaim = onView(withText("Comment"));
    public ViewInteraction editClaim = onView(withId(R.id.edit_processing_image_button));
    public ViewInteraction processingClaim = onView(withId(R.id.status_processing_image_button));
    public ViewInteraction cancelExecutorClaim = onView(withText("Cancel"));
    public ViewInteraction takeToWorkClaim = onView(withText("take to work"));
    public ViewInteraction throwOffWorkClaim = onView(withText("Throw off"));
}
