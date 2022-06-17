package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;
import static ru.iteco.fmhandroid.ui.utils.Utils.nestedScrollTo;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.SingleClaimElements;

public class SingleClaimScreen {
    SingleClaimElements Claim = new SingleClaimElements();

    public void addComment(String text) {
        Allure.step("Создание комментария");
        Claim.addComment.perform(nestedScrollTo())
                .check(matches(isDisplayed()));
        SystemClock.sleep(2000);
        Claim.addComment.perform(click());
        onView(
                allOf(
                        isDescendantOfA(withId(R.id.comment_text_input_layout)),
                        withClassName(endsWith("EditText"))
                )
        ).perform(
                typeText(text));
        Claim.save.perform(click());
    }

    public void fillComment(String comment) {
        Allure.step("Ввод комментария");
        Claim.commentField.perform(replaceText(comment));
        Claim.okPopup.perform(click());
    }

    public void save() {
        Allure.step("Сохранение");
        Claim.save.perform(click());
    }

    public void editComment(String title) {
        Allure.step("Редактирование комментария");
        onView(allOf(withId(R.id.edit_comment_image_button),
                withParent(withParent(
                        allOf(withId(R.id.comments_material_card_view),
                                withChild(withChild((
                                        withText(title))))))))).perform(click());
        Claim.okPopup.perform(click());
    }

    public void throwOff(String reason) {
        Allure.step("Отказ заявки");
        Claim.processing.perform(click());
        SystemClock.sleep(1000);
        Claim.throwOff.perform(click());
        SystemClock.sleep(1000);
        fillComment(reason);
        Claim.okPopup.perform(click());
    }

    public void execute(String reason) {
        Allure.step("Выполнение заявки");
        Claim.processing.perform(click());
        SystemClock.sleep(1000);
        Claim.toExecute.perform(click());
        fillComment(reason);
        Claim.okPopup.perform(click());
    }

    public void takeToWork() {
        Allure.step("Взятие в работу");
        Claim.processing.perform(click());
        SystemClock.sleep(1000);
        Claim.takeToWork.perform(click());
    }

    public void cancel() {
        Allure.step("Отмена");
        Claim.processing.perform(click());
        SystemClock.sleep(1000);
        Claim.cancel.perform(click());
    }

    public void status(String status) {
        Allure.step("Проверка статуса");
        SystemClock.sleep(1000);
        Claim.status.check(matches(allOf(isDisplayed(), withText(status))));
    }

    public void editClaim() {
        Allure.step("Редактирование заявки");

        Claim.editClaim.perform(click());
        Claim.editScreen.check(matches(isDisplayed()));
    }

    public void back() {
        Allure.step("Возврат назад");
        Claim.back.perform(click());
    }

    public void checkComment(String text) {
        Allure.step("Проверка комментария");
        Claim.addComment.perform(nestedScrollTo())
                .check(matches(isDisplayed()));
        onView(
                allOf(withId(R.id.comment_description_text_view), withText(text),
                        withParent(withParent(withId(R.id.claim_comments_list_recycler_view))),
                        isDisplayed()));
    }
}
