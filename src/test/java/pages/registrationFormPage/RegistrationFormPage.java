package pages.registrationFormPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.registrationFormPage.components.DatePickerComponent;
import pages.registrationFormPage.components.ResultTableComponent;
import pages.registrationFormPage.components.StateAndCityComponent;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    private final ResultTableComponent resultTable = new ResultTableComponent();
    private final DatePickerComponent datePicker = new DatePickerComponent();
    private final StateAndCityComponent stateAndCity = new StateAndCityComponent();

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");

    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement hobbiesCheckBox1 = $("#hobbies-checkbox-1");
    private final SelenideElement pictureInput = $("#uploadPicture");

    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement resultModalTitle = $("#example-modal-sizes-title-lg");

    private final SelenideElement invalidFirstNameField = $("#firstName:invalid");
    private final SelenideElement invalidEmailField = $("#userEmail:invalid");
    private final SelenideElement invalidPhoneNumberField = $("#userNumber:invalid");

    @Step("Открываем страницу /automation-practice-form")
    public void openForm() {
        open("/automation-practice-form");
    }

    //Setters
    @Step("Вводим фамилию: \"{lastName}\"")
    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Вводим имя: \"{firstName}\"")
    public RegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Вводим почту: \"{email}\"")
    public RegistrationFormPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    @Step("Вводим номер телефона: \"{phoneNumber}\"")
    public RegistrationFormPage setPhoneNumber(String phoneNumber) {
        userNumberInput.setValue(phoneNumber);
        return this;
    }

    @Step("Выбираем пол: \"{gender}\"")
    public RegistrationFormPage selectGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    @Step("Выбираем предмет: \"{subject}\"")
    public RegistrationFormPage selectSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    @Step("Вводим адрес: \"{address}\"")
    public RegistrationFormPage setCurrentAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    @Step("Выбираем хобби")
    public RegistrationFormPage selectHobbies1() {
        hobbiesCheckBox1.click();
        return this;
    }

    //Getters
    @Step("Получаем отображённое имя")
    public SelenideElement getResultModalTitle() {
        return resultModalTitle;
    }

    @Step("Находим поле с невалидным именем")
    public SelenideElement getInvalidFirstNameField(){
        return invalidFirstNameField;
    }

    @Step("Находим поле с невалидным email")
    public SelenideElement getInvalidEmailField() {
        return invalidEmailField;
    }

    @Step("Находим поле с невалидным номером")
    public SelenideElement getInvalidPhoneNumberField() {
        return invalidPhoneNumberField;
    }

    @Step("Получаем результат")
    public SelenideElement getResultValue(String fieldName) {
        return resultTable.getResultValue(fieldName);
    }

    //Actions
    @Step("Нажимаем Отпраить")
    public RegistrationFormPage submit() {
        submitButton
                .scrollIntoView("{block: 'center'}")
                .click();

        return this;
    }

    @Step("Прикладываем файл")
    public RegistrationFormPage uploadPicture(String fileName) {
        pictureInput.uploadFromClasspath(fileName);
        return this;
    }

    @Step("Выбираем город и штат")
    public RegistrationFormPage selectStateAndCity(String state, String city) {
        stateAndCity.selectStateAndCity(state, city);
        return this;
    }

    @Step("Вводим дату рождения")
    public RegistrationFormPage selectDate(String month, String year, String day) {
        datePicker.selectDate(month, year, day);
        return this;
    }
}
