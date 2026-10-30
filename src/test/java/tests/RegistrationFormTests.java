package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static data.FormData.*;

public class RegistrationFormTests extends BaseTest {

    @BeforeEach
    void openRegistrationForm() {
        registrationFormPage.openForm();
    }

    @Test
    void shouldSubmitRegistrationFormWithAllFields() {
        registrationFormPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .selectGender(gender)
                .setPhoneNumber(phoneNumber)
                .selectDate(monthOfBirthday, yeaOfBirthday, dayOfBirthday)
                .selectSubject(subject)
                .selectHobbies1()
                .uploadPicture(picture)
                .setCurrentAddress(address)
                .selectStateAndCity(state, city)
                .submit();

        registrationFormPage
                .getResultModalTitle()
                .shouldHave(text("Thanks for submitting the form"));

        registrationFormPage
                .getResultValue("Student Name")
                .shouldHave(text(firstName + " " + lastName));

        registrationFormPage
                .getResultValue("Student Email")
                .shouldHave(text(email));

        registrationFormPage
                .getResultValue("Gender")
                .shouldHave(text(gender));

        registrationFormPage
                .getResultValue("Mobile")
                .shouldHave(text(phoneNumber));

        registrationFormPage
                .getResultValue("Date of Birth")
                .shouldHave(text(dateOfBirth));

        registrationFormPage
                .getResultValue("Subjects")
                .shouldHave(text(subject));

        registrationFormPage
                .getResultValue("Hobbies")
                .shouldHave(text("Sports"));

        registrationFormPage
                .getResultValue("Picture")
                .shouldHave(text(picture));

        registrationFormPage
                .getResultValue("Address")
                .shouldHave(text(address));

        registrationFormPage
                .getResultValue("State and City")
                .shouldHave(text(state + " " + city));

    }

    @Test
    void shouldSubmitRegistrationFormWithRequiredFields() {
        registrationFormPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .selectGender(gender)
                .setPhoneNumber(phoneNumber)
                .submit();

        registrationFormPage
                .getResultModalTitle()
                .shouldHave(text("Thanks for submitting the form"));

        registrationFormPage
                .getResultValue("Student Name")
                .shouldHave(text(firstName + " " + lastName));

        registrationFormPage
                .getResultValue("Gender")
                .shouldHave(text(gender));

        registrationFormPage
                .getResultValue("Mobile")
                .shouldHave(text(phoneNumber));
    }

    @Test
    void shouldRejectRegistrationWithInvalidPhoneNumber() {
        registrationFormPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .selectGender(gender)
                .setPhoneNumber(testPhoneNumber)
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
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(test)
                .selectGender(gender)
                .setPhoneNumber(phoneNumber)
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
                .setLastName(lastName)
                .selectGender(gender)
                .setPhoneNumber(phoneNumber)
                .submit();

        registrationFormPage
                .getResultModalTitle()
                .shouldNotBe(visible);

        registrationFormPage
                .getInvalidFirstNameField()
                .shouldBe(visible);
    }
}
