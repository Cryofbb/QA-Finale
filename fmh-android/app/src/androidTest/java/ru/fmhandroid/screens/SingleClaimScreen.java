package ru.fmhandroid.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import ru.fmhandroid.elements.SingleClaimElements;

public class SingleClaimScreen {
    SingleClaimElements Claim = new SingleClaimElements();

    public void addComment() {
        Claim.addComment.perform(click());
    }

    public void fillComment(String comment) {
        Claim.commentField.perform(replaceText(comment));
    }

    public void save() {
        Claim.save.perform(click());
    }

    public void editComment() {
        Claim.editComment.perform(click());
    }

    public void openProcessing() {
        Claim.processing.perform(click());
    }

    public void throwOff(String reason) {
        openProcessing();
        Claim.throwOff.perform(click());
        fillComment(reason);
        save();
    }

    public void execute(String reason) {
        openProcessing();
        Claim.toExecute.perform(click());
        fillComment(reason);
        save();
    }

    public void takeToWork() {
        openProcessing();
        Claim.takeToWork.perform(click());
    }

    public void cancel() {
        openProcessing();
        Claim.cancel.perform(click());
    }

    public void editClaim() {
        Claim.editClaim.perform(click());
        Claim.editScreen.check(matches(isDisplayed()));
    }

    public void back() {
        Claim.back.perform(click());
    }
}
