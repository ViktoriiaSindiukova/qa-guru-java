package pages.RegistrationFormPage.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCityComponent {

    private final SelenideElement stateDropdown = $("#state");
    private final SelenideElement cityDropdown = $("#city");

    public void selectStateAndCity(String state, String city) {
        stateDropdown.click();
        $(byText(state)).click();

        cityDropdown.click();
        $(byText(city)).click();
    }
}
