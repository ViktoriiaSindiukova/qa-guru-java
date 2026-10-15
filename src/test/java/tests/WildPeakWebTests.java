package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Duration;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class WildPeakWebTests {

    @BeforeEach
    void openWeb() {
        Configuration.baseUrl = "https://wildsiberia.ru";
        open("/wild-peak");
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    static Stream<Arguments> navigationMenuShouldDisplayCorrectButtons() {
        return Stream.of(
                Arguments.of("Маршрут 7"),
                Arguments.of("Маршрут 15"),
                Arguments.of("Маршрут 35"),
                Arguments.of("Маршрут 66"),
                Arguments.of("FAQ Атлета"),
                Arguments.of("Wild Camp"),
                Arguments.of("Регистрация")
        );
    }

    @MethodSource
    @ParameterizedTest()
    @DisplayName("При окрытии сайта Wild Peak должны корректно отображаться необходимые пункты меню")
    void navigationMenuShouldDisplayCorrectButtons(String menuItem) {
        $("[data-artboard-recid='599414375']")
                .$$(".tn-atom__button-text")
                .findBy(text(menuItem))
                .shouldBe(visible);
    }

    @CsvFileSource(resources = "/test-data/raceDistanceCardsShouldBeDisplayed.csv")
    @ParameterizedTest(name = "Для дистанции {0}, должна отобразиться стоимость {2}")
    @DisplayName("Для каждой дистанции должна отобразиться стоимость")
    void raceDistanceCardsShouldBeDisplayed(String distance, String distanceId, String price, String priceId) {
        SelenideElement distanceElement = $(
                "[data-elem-id='" + distanceId + "'] .tn-atom"
        );

        SelenideElement priceElement = $(
                "[data-elem-id='" + priceId + "'] .tn-atom"
        );

        distanceElement.scrollIntoView("{block: 'center'}");
        distanceElement.shouldBe(visible, Duration.ofSeconds(15));
        distanceElement.shouldHave(text(distance));

        priceElement.shouldHave(text(price));
    }

    @CsvSource({
            "18 лет+, 1671778810276",
            "Страховка, 1671778849921",
            "Медицинская справка, 1671778869926"
    })
    @ParameterizedTest
    @DisplayName("Должны отобразится требования к атлетам")
    void athleteRequirementsShouldBeDisplayed(String expectedText, String elementId) {
        SelenideElement block = $(
                "[data-elem-id='" + elementId + "'] .tn-atom"
        );

        block.scrollIntoView("{block: 'center'}");
        block.shouldBe(visible, Duration.ofSeconds(15));
        block.shouldHave(text(expectedText));
    }

    @ValueSource(strings = {
            "На 7 км допуск с 14 лет",
            "на 15 км - с 16 лет",
            "Максимальный возраст мы не ограничиваем"
    })
    @ParameterizedTest
    @DisplayName("Должны отображаться возрастные ограничения")
    void ageRequirementsShouldBeDisplayed(String expectedText) {
        SelenideElement infoBlosk = $("[data-elem-id='1671778974279'] .tn-atom");

        infoBlosk.scrollIntoView("{block: 'center'}");
        infoBlosk.shouldBe(visible, Duration.ofSeconds(15));
        infoBlosk.shouldHave(text(expectedText));
    }
}
