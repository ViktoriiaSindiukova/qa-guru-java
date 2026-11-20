package tests;

import data.FormData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;

public class TextBoxTests extends BaseTest {

    private FormData formData;

    @BeforeEach
    void openTextBox() {
        formData = new FormData();
        textBoxPage.openPage();
    }

    @Test
    void shouldDisplayNameAfterFormSubmission() {
        textBoxPage
                .enterName(formData.firstName)
                .submit();

        Assertions.assertEquals(
                "Name:" + formData.firstName,
                textBoxPage.getDisplayedName()
        );
    }

    @Test
    void shouldRejectInvalidEmail() {
        textBoxPage
                .enterEmail(formData.invalidEmail)
                .submit()
                .getInvalidEmailField()
                .shouldBe(visible);
    }
}
