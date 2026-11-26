package tests;

import data.FormData;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;

@DisplayName("Проверки формы Text Box")
public class TextBoxTests extends BaseTest {

    private FormData formData;

    @BeforeEach
    void openTextBox() {
        formData = new FormData();
        textBoxPage.openPage();
    }

    @Test
    @DisplayName("Отображение имени после отправки формы")
    void shouldDisplayNameAfterFormSubmission() {

        step("Заполняем форму", () -> {
            textBoxPage
                    .enterName(formData.firstName)
                    .submit();
        });

        step("Проверяем результат", () -> {
            Assertions.assertEquals(
                    "Name:" + formData.firstName,
                    textBoxPage.getDisplayedName()
            );
        });
    }

    @Test
    @DisplayName("Отказ при отправке некорректного email")
    void shouldRejectInvalidEmail() {
        step("Вводим некорректный email и отправляем форму", () -> {
            textBoxPage
                    .enterEmail(formData.invalidEmail)
                    .submit();
        });

        step("Проверяем, что поле email отмечено как невалидное", () -> {
            textBoxPage
                    .getInvalidEmailField()
                    .shouldBe(visible);
        });
    }
}
