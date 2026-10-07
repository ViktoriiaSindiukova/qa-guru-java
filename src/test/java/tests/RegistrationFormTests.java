package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTests extends BaseTest {

    @BeforeEach
    void openRegistrationForm() {
        open("/automation-practice-form");
    }

    @Test
    void successfulRegistrationWithAllFieldsTest() {
        $("#firstName").setValue("Viktoriia");
        $("#lastName").setValue("Sindyukova");
        $("#userEmail").setValue("test@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1231231212");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__month").$(byText("23")).click();

        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFromClasspath("1546-001.webp");
        $("#currentAddress").setValue("Комсомольская 18");

        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg")
                .shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive")
                .$(byText("Student Name"))
                .parent()
                .shouldHave(text("Viktoriia Sindyukova"));

        $(".table-responsive")
                .$(byText("Student Email"))
                .parent()
                .shouldHave(text("test@gmail.com"));

        $(".table-responsive")
                .$(byText("Gender"))
                .parent()
                .shouldHave(text("Female"));

        $(".table-responsive")
                .$(byText("Mobile"))
                .parent()
                .shouldHave(text("1231231212"));

        $(".table-responsive")
                .$(byText("Date of Birth"))
                .parent()
                .shouldHave(text("23 May,1994"));

        $(".table-responsive")
                .$(byText("Subjects"))
                .parent()
                .shouldHave(text("Physics"));

        $(".table-responsive")
                .$(byText("Hobbies"))
                .parent()
                .shouldHave(text("Sports"));

        $(".table-responsive")
                .$(byText("Picture"))
                .parent()
                .shouldHave(text("1546-001.webp"));

        $(".table-responsive")
                .$(byText("Address"))
                .parent()
                .shouldHave(text("Комсомольская 18"));

        $(".table-responsive")
                .$(byText("State and City"))
                .parent()
                .shouldHave(text("NCR Delhi"));

    }

    @Test
    void successfulRegistrationWithRequiredFieldsTest() {
        $("#firstName").setValue("Viktoriia");
        $("#lastName").setValue("Sindyukova");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1231231212");

        $("#submit")
                .scrollIntoView("{block: 'center'}")
                .click();

        $("#example-modal-sizes-title-lg")
                .shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive")
                .$(byText("Student Name"))
                .parent()
                .shouldHave(text("Viktoriia Sindyukova"));

        $(".table-responsive")
                .$(byText("Gender"))
                .parent()
                .shouldHave(text("Female"));

        $(".table-responsive")
                .$(byText("Mobile"))
                .parent()
                .shouldHave(text("1231231212"));
    }

    @Test
    void registrationWithInvalidMobileTest() {
        $("#firstName").setValue("Viktoriia");
        $("#lastName").setValue("Sindyukova");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("123123");

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
        $("#firstName").setValue("Viktoriia");
        $("#lastName").setValue("Sindyukova");
        $("#userEmail").setValue("test");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1231231212");

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
        $("#lastName").setValue("Sindyukova");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1231231212");

        $("#submit")
                .scrollIntoView("{block: 'center'}")
                .click();

        $("#example-modal-sizes-title-lg")
                .shouldNotBe(visible);

        $("#firstName:invalid")
                .shouldBe(visible);
    }
}
