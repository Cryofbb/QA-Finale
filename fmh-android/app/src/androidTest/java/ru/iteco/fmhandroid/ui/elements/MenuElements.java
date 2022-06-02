package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MenuElements {
    public ViewInteraction open = onView(withId(R.id.main_menu_image_button));
    public ViewInteraction main = onView(withText("Main"));
    public ViewInteraction claims = onView(withText("Claims"));
    public ViewInteraction news = onView(withText("News"));
    public ViewInteraction about = onView(withText("About"));
    public ViewInteraction quotes = onView(withId(R.id.our_mission_image_button));
    public ViewInteraction profile = onView(withId(R.id.authorization_image_button));
    public ViewInteraction signOut = onView((withText("Log out")));
    public ViewInteraction authScreen = onView(allOf(withText("Authorization")));
    public ViewInteraction aboutScreen = onView(withId(R.id.about_version_title_text_view));
    public ViewInteraction quotesScreen = onView(withId(R.id.our_mission_title_text_view));
    public ViewInteraction newsScreen = onView(withId(R.id.sort_news_material_button));
    public ViewInteraction claimsScreen = onView(withId(R.id.add_new_claim_material_button));
    public ViewInteraction mainScreen = onView(withId(R.id.all_news_text_view));
    public ViewInteraction logo = onView(withId(R.id.trademark_image_view));
}
