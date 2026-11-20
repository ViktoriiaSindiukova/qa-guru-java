package data;

import com.github.javafaker.Faker;
import data.enums.State;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import static data.TestDataGenerator.*;

public class FormData {


    private static final Faker faker = new Faker();

    public final String firstName = getFirstName();
    public final String lastName = getLastName();
    public final String email = getEmail();
    public final String phoneNumber = getPhoneNumber();
    public final String gender = getGender();

    public final LocalDate birthday = TestDataGenerator.getBirthday();

    public final String monthOfBirthday =
            birthday.getMonth().getDisplayName(
                    TextStyle.FULL,
                    Locale.ENGLISH
            );
    public final String yearOfBirthday = String.valueOf(birthday.getYear());
    public final String dayOfBirthday = String.valueOf(birthday.getDayOfMonth());
    public final String dateOfBirth = birthday.format(
            DateTimeFormatter.ofPattern("d MMMM,yyyy", Locale.ENGLISH)
    );

    public final String address = getAddress();
    public final String subject = getSubject();
    public final State stateAndCity = getStateAndCity();
    public final String state = stateAndCity.getDisplayName();
    public final String city = faker.options().option(stateAndCity.getCities());
    public final String picture = "1546-001.webp";

    public final String invalidEmail = "test";
    public final String invalidPhoneNumber = "123123";
}
