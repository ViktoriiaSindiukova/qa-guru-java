package data;

import com.github.javafaker.Faker;
import data.enums.Gender;
import data.enums.State;
import data.enums.Subject;

import java.time.LocalDate;
import java.time.ZoneId;

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
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getGender() {
        return faker.options().option(Gender.values()).name();
    }

    public static String getSubject() {
        return faker.options().option(Subject.values()).name();
    }

    public static State getStateAndCity() {
        return faker.options().option(State.values());
    }

    public static LocalDate getBirthday() {
        return faker.date().birthday().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
