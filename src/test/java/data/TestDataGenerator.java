package data;

import com.github.javafaker.Faker;
import data.enums.Gender;
import data.enums.State;
import data.enums.Subject;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class TestDataGenerator {

    private static final Faker faker = new Faker();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getAddress() {
        return faker.address().fullAddress();
    }

    public static String getPhoneNumber() {
        return faker.number().digits(10);
    }

    public static String getGender() {
        Gender[] genders = Gender.values();
        return genders[getRandomInt(0, genders.length)].name();
    }

    public static String getSubject() {
        Subject[] subjects = Subject.values();
        return subjects[getRandomInt(0, subjects.length)].name();
    }

    public static State getStateAndCity() {
        State[] states = State.values();
        return states[getRandomInt(0, states.length)];
    }

    public static LocalDate getBirthday() {
        return LocalDate.of(
                getRandomInt(1980, 2000),
                getRandomInt(1, 13),
                getRandomInt(1, 29)
        );
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
