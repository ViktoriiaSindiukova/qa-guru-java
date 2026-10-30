package pages.RegistrationFormPage.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DatePickerComponent {

    private final SelenideElement dateInput = $("#dateOfBirthInput");
    private final SelenideElement monthSelect = $(".react-datepicker__month-select");
    private final SelenideElement yearSelect = $(".react-datepicker__year-select");
    private final SelenideElement calendar = $(".react-datepicker__month");

    public void selectDate(String month, String year, String day) {
        dateInput.click();
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        calendar.$(byText(day)).click();
    }
}
