package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static data.FormData.*;

public class RegistrationFormTests extends BaseTest {

    @BeforeEach
    void openRegistrationForm() {
        open("/automation-practice-form");
    }

    @Test
    void successfulRegistrationWithAllFieldsTest() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirthday);
        $(".react-datepicker__year-select").selectOption(yeaOfBirthday);
        $(".react-datepicker__month").$(byText(dayOfBirthday)).click();

        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(address);

        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg")
                .shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive")
                .$(byText("Student Name"))
                .parent()
                .shouldHave(text(firstName + " " + lastName));

        $(".table-responsive")
                .$(byText("Student Email"))
                .parent()
                .shouldHave(text(email));

        $(".table-responsive")
                .$(byText("Gender"))
                .parent()
                .shouldHave(text(gender));

        $(".table-responsive")
                .$(byText("Mobile"))
                .parent()
                .shouldHave(text(phoneNumber));

        $(".table-responsive")
                .$(byText("Date of Birth"))
                .parent()
                .shouldHave(text(dateOfBirth));

        $(".table-responsive")
                .$(byText("Subjects"))
                .parent()
                .shouldHave(text(subject));

        $(".table-responsive")
                .$(byText("Hobbies"))
                .parent()
                .shouldHave(text("Sports"));

        $(".table-responsive")
                .$(byText("Picture"))
                .parent()
                .shouldHave(text(picture));

        $(".table-responsive")
                .$(byText("Address"))
                .parent()
                .shouldHave(text(address));

        $(".table-responsive")
                .$(byText("State and City"))
                .parent()
                .shouldHave(text(state + " " + city));

    }

    @Test
    void successfulRegistrationWithRequiredFieldsTest() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);

        $("#submit")
                .scrollIntoView("{block: 'center'}")
                .click();

        $("#example-modal-sizes-title-lg")
                .shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive")
                .$(byText("Student Name"))
                .parent()
                .shouldHave(text(firstName + " " + lastName));

        $(".table-responsive")
                .$(byText("Gender"))
                .parent()
                .shouldHave(text(gender));

        $(".table-responsive")
                .$(byText("Mobile"))
                .parent()
                .shouldHave(text(phoneNumber));
    }

    @Test
    void registrationWithInvalidMobileTest() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(testPhoneNumber);

        $("#submit")
                .scrollIntoView("{block: 'center'}")
                .click();

        $("#example-modal-sizes-title-lg")
                .shouldNotBe(visible);

        $("#userNumber:invalid")
                .shouldBe(visible);
    }

    @Test
    void registrationWithInvalidEmailTest() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(test);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);

        $("#submit")
                .scrollIntoView("{block: 'center'}")
                .click();

        $("#example-modal-sizes-title-lg")
                .shouldNotBe(visible);

        $("#userEmail:invalid")
                .shouldBe(visible);
    }

    @Test
    void registrationWithoutFirstNameTest() {
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);

        $("#submit")
                .scrollIntoView("{block: 'center'}")
                .click();

        $("#example-modal-sizes-title-lg")
                .shouldNotBe(visible);

        $("#firstName:invalid")
                .shouldBe(visible);
    }
}
