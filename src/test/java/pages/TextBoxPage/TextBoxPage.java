package pages.TextBoxPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement displayedName = $("#name");
    private final SelenideElement invalidEmailField = $("#userEmail:invalid");

    public void openPage() {
        open("/text-box");
    }

    public TextBoxPage enterName(String name) {
        userNameInput.setValue(name);
        return this;
    }

    public TextBoxPage enterEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public TextBoxPage submit() {
        submitButton.click();
        return this;
    }

    public String getDisplayedName() {
       return displayedName.getText();
    }

    public SelenideElement getInvalidEmailField() {
        return invalidEmailField;
    }
}
