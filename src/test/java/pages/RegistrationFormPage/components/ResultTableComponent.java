package pages.RegistrationFormPage.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    private final SelenideElement table = $(".table-responsive");

    public SelenideElement getResultValue(String fieldName) {
        return table
                .$(byText(fieldName))
                .parent();
    }
}
