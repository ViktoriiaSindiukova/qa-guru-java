package pages.RegistrationFormPage;

import com.codeborne.selenide.SelenideElement;
import pages.RegistrationFormPage.components.DatePickerComponent;
import pages.RegistrationFormPage.components.ResultTableComponent;
import pages.RegistrationFormPage.components.StateAndCityComponent;


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

    public void openForm() {
        open("/automation-practice-form");
    }

    //Setters
    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationFormPage setPhoneNumber(String phoneNumber) {
        userNumberInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationFormPage selectGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public RegistrationFormPage selectSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationFormPage selectHobbies1() {
        hobbiesCheckBox1.click();
        return this;
    }

    //Getters
    public SelenideElement getResultModalTitle() {
        return resultModalTitle;
    }

    public SelenideElement getInvalidFirstNameField(){
        return invalidFirstNameField;
    }

    public SelenideElement getInvalidEmailField() {
        return invalidEmailField;
    }

    public SelenideElement getInvalidPhoneNumberField() {
        return invalidPhoneNumberField;
    }

    public SelenideElement getResultValue(String fieldName) {
        return resultTable.getResultValue(fieldName);
    }

    //Actions
    public RegistrationFormPage submit() {
        submitButton
                .scrollIntoView("{block: 'center'}")
                .click();

        return this;
    }

    public RegistrationFormPage uploadPicture(String fileName) {
        pictureInput.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationFormPage selectStateAndCity(String state, String city) {
        stateAndCity.selectStateAndCity(state, city);
        return this;
    }

    public RegistrationFormPage selectDate(String month, String year, String day) {
        datePicker.selectDate(month, year, day);
        return this;
    }
}
