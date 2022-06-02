package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.Utils.*;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainElements {
    public ViewInteraction news = onView(withText("News"));
    public ViewInteraction claims = onView(withText("Claims"));
    public ViewInteraction creating = onView(withText("Creating"));
    public ViewInteraction allNews = onView(withId(R.id.all_news_text_view));
    public ViewInteraction allClaims = onView(withId(R.id.all_claims_text_view));
    public ViewInteraction addClaim = onView(withId(R.id.add_new_claim_material_button));
    public ViewInteraction title = onView(withId(R.id.news_item_title_text_view));
    public ViewInteraction description = onView(withId(R.id.news_item_description_text_view));
    public ViewInteraction executor = onView(withId(R.id.executor_name_label_material_text_view));
    public ViewInteraction closeClaim = onView(withId(R.id.close_image_button));

    //Надо чекнуть экспанды
    public ViewInteraction expandAllNews = onView(withIndex(withId(R.id.expand_material_button), 0));
    public ViewInteraction expandAllClaims = onView(withIndex(withId(R.id.expand_material_button), 1));


}
