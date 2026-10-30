package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationFormPage.RegistrationFormPage;
import pages.TextBoxPage.TextBoxPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    TextBoxPage textBoxPage = new TextBoxPage();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setupEnvironment() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
