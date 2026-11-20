package tests;

import data.FormData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class RegistrationFormTests extends BaseTest {

    private FormData formData;

    @BeforeEach
    void openRegistrationForm() {
        formData = new FormData();
        registrationFormPage.openForm();
    }

    @Test
    void shouldSubmitRegistrationFormWithAllFields() {
        registrationFormPage
                .setFirstName(formData.firstName)
                .setLastName(formData.lastName)
                .setEmail(formData.email)
                .selectGender(formData.gender)
                .setPhoneNumber(formData.phoneNumber)
                .selectDate(formData.monthOfBirthday, formData.yearOfBirthday, formData.dayOfBirthday)
                .selectSubject(formData.subject)
                .selectHobbies1()
                .uploadPicture(formData.picture)
                .setCurrentAddress(formData.address)
                .selectStateAndCity(formData.state, formData.city)
                .submit();

        registrationFormPage
                .getResultModalTitle()
                .shouldHave(text("Thanks for submitting the form"));

        registrationFormPage
                .getResultValue("Student Name")
                .shouldHave(
                        text(formData.firstName + " " + formData.lastName)
                );

        registrationFormPage
                .getResultValue("Student Email")
                .shouldHave(text(formData.email));

        registrationFormPage
                .getResultValue("Gender")
                .shouldHave(text(formData.gender));

        registrationFormPage
                .getResultValue("Mobile")
                .shouldHave(text(formData.phoneNumber));

        registrationFormPage
                .getResultValue("Date of Birth")
                .shouldHave(text(formData.dateOfBirth));

        registrationFormPage
                .getResultValue("Subjects")
                .shouldHave(text(formData.subject));

        registrationFormPage
                .getResultValue("Hobbies")
                .shouldHave(text("Sports"));

        registrationFormPage
                .getResultValue("Picture")
                .shouldHave(text(formData.picture));

        registrationFormPage
                .getResultValue("Address")
                .shouldHave(text(formData.address));

        registrationFormPage
                .getResultValue("State and City")
                .shouldHave(text(formData.state + " " + formData.city));

    }

    @Test
    void shouldSubmitRegistrationFormWithRequiredFields() {
        registrationFormPage
                .setFirstName(formData.firstName)
                .setLastName(formData.lastName)
                .selectGender(formData.gender)
                .setPhoneNumber(formData.phoneNumber)
                .submit();

        registrationFormPage
                .getResultModalTitle()
                .shouldHave(text("Thanks for submitting the form"));

        registrationFormPage
                .getResultValue("Student Name")
                .shouldHave(text(formData.firstName + " " + formData.lastName));

        registrationFormPage
                .getResultValue("Gender")
                .shouldHave(text(formData.gender));

        registrationFormPage
                .getResultValue("Mobile")
                .shouldHave(text(formData.phoneNumber));
    }

    @Test
    void shouldRejectRegistrationWithInvalidPhoneNumber() {
        registrationFormPage
                .setFirstName(formData.firstName)
                .setLastName(formData.lastName)
                .selectGender(formData.gender)
                .setPhoneNumber(formData.invalidPhoneNumber)
                .submit();

        registrationFormPage
                .getResultModalTitle()
                .shouldNotBe(visible);

        registrationFormPage
                .getInvalidPhoneNumberField()
                .shouldBe(visible);
    }

    @Test
    void shouldRejectRegistrationWithInvalidEmail() {
        registrationFormPage
                .setFirstName(formData.firstName)
                .setLastName(formData.lastName)
                .setEmail(formData.invalidEmail)
                .selectGender(formData.gender)
                .setPhoneNumber(formData.phoneNumber)
                .submit();

        registrationFormPage
                .getResultModalTitle()
                .shouldNotBe(visible);

        registrationFormPage
                .getInvalidEmailField()
                .shouldBe(visible);
    }

    @Test
    void shouldRejectRegistrationWithoutFirstName() {
        registrationFormPage
                .setLastName(formData.lastName)
                .selectGender(formData.gender)
                .setPhoneNumber(formData.phoneNumber)
                .submit();

        registrationFormPage
                .getResultModalTitle()
                .shouldNotBe(visible);

        registrationFormPage
                .getInvalidFirstNameField()
                .shouldBe(visible);
    }
}
