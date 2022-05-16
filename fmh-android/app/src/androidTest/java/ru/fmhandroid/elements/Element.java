package ru.fmhandroid.elements;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;


public class Element {
    //Loading screen
    public ViewInteraction splashScreen = onView(withId(R.id.splash_screen_circular_progress_indicator));
    public ViewInteraction splashScreenText = onView(withId(R.id.splashscreen_text_view));

    //Menu buttons
    public ViewInteraction burgerMenu = onView(withId(R.id.main_menu_image_button));
    public ViewInteraction mainLogo = onView(withId(R.id.trademark_image_view));
    public ViewInteraction quotesButton = onView(withId(R.id.our_mission_image_button));
    public ViewInteraction authButton = onView(withId(R.id.authorization_image_button));
    public ViewInteraction menuMain = onView(withText("Main"));
    public ViewInteraction menuClaims = onView(withText("Claims"));
    public ViewInteraction menuNews = onView(withText("News"));
    public ViewInteraction menuAbout = onView(withText("About"));
    public ViewInteraction exitButton = onView((withText("Log out")));

    //Buttons
    public ViewInteraction buttonSave = onView(withId(R.id.save_button));
    public ViewInteraction buttonCancel = onView(withId(R.id.cancel_button));
    public ViewInteraction buttonStatusSwitch = onView(withId(R.id.switcher));
    public ViewInteraction switcherActiveStatus = onView(withText("Active"));
    public ViewInteraction switcherNotActiveStatus = onView(withText("Not active"));

    //Filter
    public ViewInteraction buttonClaimsFiltering = onView(withId(R.id.filters_material_button));
    public ViewInteraction buttonNewsFiltering = onView(withId(R.id.filter_news_material_button));
    public ViewInteraction buttonNewsSorting = onView(withId(R.id.sort_news_material_button));
    public ViewInteraction openFilterButton = onView(withId(R.id.item_filter_open));
    public ViewInteraction inProgressFilterButton = onView(withId(R.id.item_filter_in_progress));
    public ViewInteraction executedFilterButton = onView(withId(R.id.item_filter_executed));
    public ViewInteraction cancelledFilterButton = onView(withId(R.id.item_filter_cancelled));
    public ViewInteraction claimOkFilterButton = onView(withId(R.id.claim_list_filter_ok_material_button));
    public ViewInteraction claimCancelFilterButton = onView(withId(R.id.claim_filter_cancel_material_button));
    public ViewInteraction newsCategoryFilterButton = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction newsDateStartFilterButton = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public ViewInteraction newsDateEndFilterButton = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public ViewInteraction newsOkFilterButton = onView(withId(R.id.filter_button));
    public ViewInteraction checkboxNewsActive = onView(withId(R.id.filter_news_active_material_check_box));
    public ViewInteraction checkboxNewsNotActive = onView(withId(R.id.filter_news_inactive_material_check_box));
}
