package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends BaseTest {

    @BeforeEach
    void openTextBox() {
        open("/text-box");
    }

    @Test
    void successfulTextBoxWithFullNameTest() {
        $("#userName").setValue("Viktoriia");
        $("#submit").click();

        $("#name")
                .shouldHave(text("Viktoriia"));
    }

    @Test
    void textBoxWithInvalidEmailTest() {
        $("#userEmail").setValue("test");
        $("#submit").click();

        $("#userEmail:invalid")
                .shouldBe(visible);
    }
}
