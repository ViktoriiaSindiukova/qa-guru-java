package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static data.FormData.firstName;
import static data.FormData.test;

public class TextBoxTests extends BaseTest {

    @BeforeEach
    void openTextBox() {
        textBoxPage.openPage();
    }

    @Test
    void shouldDisplayNameAfterFormSubmission() {
        textBoxPage
                .enterName(firstName)
                .submit();

        Assertions.assertEquals(
                "Name:" + firstName,
                textBoxPage.getDisplayedName()
        );
    }

    @Test
    void shouldRejectInvalidEmail() {
        textBoxPage
                .enterEmail(test)
                .submit()
                .getInvalidEmailField()
                .shouldBe(visible);
    }
}
