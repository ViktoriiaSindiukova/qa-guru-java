package pages.textBoxPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement displayedName = $("#name");
    private final SelenideElement invalidEmailField = $("#userEmail:invalid");


    @Step("Открываем страницу /text-box")
    public void openPage() {
        open("/text-box");
    }

    @Step("Вводим имя: \"{name}\"")
    public TextBoxPage enterName(String name) {
        userNameInput.setValue(name);
        return this;
    }

    @Step("Вводим почту: \"{email}\"")
    public TextBoxPage enterEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    @Step("Нажимаем Отпраить")
    public TextBoxPage submit() {
        submitButton.click();
        return this;
    }

    @Step("Получаем отображённое имя")
    public String getDisplayedName() {
       return displayedName.getText();
    }

    @Step("Находим поле с невалидным email")
    public SelenideElement getInvalidEmailField() {
        return invalidEmailField;
    }
}
