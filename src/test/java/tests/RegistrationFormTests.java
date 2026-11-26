package tests;

import data.FormData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;

@DisplayName("Проверки формы Student Registration Form")
public class RegistrationFormTests extends BaseTest {

    private FormData formData;

    @BeforeEach
    void openRegistrationForm() {
        formData = new FormData();
        registrationFormPage.openForm();
    }

    @Test
    @DisplayName("Отображение всех полей после отправки формы")
    void shouldSubmitRegistrationFormWithAllFields() {

        step("Заполняем форму", () -> {
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
        });

        step("Проверяем результат", () -> {
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
        });

    }

    @Test
    @DisplayName("Отображение обязательных послей отправки формы")
    void shouldSubmitRegistrationFormWithRequiredFields() {

        step("Заполняем форму", () -> {
            registrationFormPage
                    .setFirstName(formData.firstName)
                    .setLastName(formData.lastName)
                    .selectGender(formData.gender)
                    .setPhoneNumber(formData.phoneNumber)
                    .submit();
        });

        step("Проверяем результат", () -> {
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
        });
    }

    @Test
    @DisplayName("Отказ при отправке некорректного телефонного номера")
    void shouldRejectRegistrationWithInvalidPhoneNumber() {

        step("Заполняем форму", () -> {
            registrationFormPage
                    .setFirstName(formData.firstName)
                    .setLastName(formData.lastName)
                    .selectGender(formData.gender)
                    .setPhoneNumber(formData.invalidPhoneNumber)
                    .submit();
        });

        step("Проверяем результат", () -> {
            registrationFormPage
                    .getResultModalTitle()
                    .shouldNotBe(visible);

            registrationFormPage
                    .getInvalidPhoneNumberField()
                    .shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Отказ при отправке некорректного телефонного email")
    void shouldRejectRegistrationWithInvalidEmail() {

        step("Заполняем форму", () -> {
            registrationFormPage
                    .setFirstName(formData.firstName)
                    .setLastName(formData.lastName)
                    .setEmail(formData.invalidEmail)
                    .selectGender(formData.gender)
                    .setPhoneNumber(formData.phoneNumber)
                    .submit();
        });

        step("Проверяем результат", () -> {
            registrationFormPage
                    .getResultModalTitle()
                    .shouldNotBe(visible);

            registrationFormPage
                    .getInvalidEmailField()
                    .shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Отказ при отправке формы без заполненного имени")
    void shouldRejectRegistrationWithoutFirstName() {

        step("Заполняем форму", () -> {
            registrationFormPage
                    .setLastName(formData.lastName)
                    .selectGender(formData.gender)
                    .setPhoneNumber(formData.phoneNumber)
                    .submit();
        });

        step("Проверяем результат", () -> {
            registrationFormPage
                    .getResultModalTitle()
                    .shouldNotBe(visible);

            registrationFormPage
                    .getInvalidFirstNameField()
                    .shouldBe(visible);
        });
    }
}
