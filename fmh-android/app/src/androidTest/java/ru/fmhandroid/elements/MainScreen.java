package ru.fmhandroid.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.fmhandroid.utils.Utils.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainScreen {
    //News
    public ViewInteraction news = onView((withText("News")));
    public ViewInteraction allNewsButton = onView((withId(R.id.all_news_text_view)));
    public ViewInteraction expandAllNews = onView(withIndex(withId(R.id.expand_material_button), 0));
    public ViewInteraction expandNews = onView(withIndex(withId(R.id.news_item_title_text_view), 0));
    public ViewInteraction newsDescription = onView(withIndex(withId(R.id.news_item_description_text_view), 0));
    //Claims
    public ViewInteraction expandAllClaims = onView(withIndex(withId(R.id.expand_material_button), 1));
    public ViewInteraction allClaimsButton = onView((withId(R.id.all_claims_text_view)));
    public ViewInteraction addNewClaim = onView((withId(R.id.add_new_claim_material_button)));
    public ViewInteraction claimTitle = onView(withIndex(withId(R.id.description_material_text_view), 0));
    public ViewInteraction claimExecutor = onView(withIndex(withId(R.id.executor_name_material_text_view), 0));
}
