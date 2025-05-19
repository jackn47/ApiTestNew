package org.example.utils;

import com.github.javafaker.Faker;
import org.example.models.AuthRequest;
import org.example.models.RegistrationRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TestDataGenerator {
    private static final Faker faker = new Faker();

    public static RegistrationRequest generateValidRegistrationRequest() {
        Map<String, Object> extProfile = new HashMap<>();
        extProfile.put("key", faker.lorem().word());

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = "danfirst69+AT+" + UUID.randomUUID() + "@gmail.com";
        String login = faker.name().username() + System.currentTimeMillis();
        String birthDay = String.format("%02d", faker.number().numberBetween(1, 28));
        String birthMonth = String.format("%02d", faker.number().numberBetween(1, 12));
        String birthYear = String.valueOf(faker.number().numberBetween(1980, 2003));
        String birthDate = birthYear + "-" + birthMonth + "-" + birthDay;

        return RegistrationRequest.builder()
                .address(faker.address().streetAddress())
                .bankName(faker.company().name())
                .bankNameText(faker.company().industry())
                .birthDay(birthDay)
                .birthMonth(birthMonth)
                .birthYear(birthYear)
                .branchCode("BR" + faker.number().digits(3))
                .city(faker.address().city())
                .countryCode("aze")
                .currency("USD")
                .email(email)
                .emailVerified("true")
                .extProfile(extProfile)
                .firstName(firstName)
                .lastName(lastName)
                .gender("m")
                .ibanNumber("DE89" + faker.number().digits(18))
                .idNumber("ID" + faker.number().digits(7))
                .idUser(UUID.randomUUID().toString())
                .login(login)
                .newEmail(null)
                .phoneAltCode("+1")
                .phoneAltNumber(faker.phoneNumber().subscriberNumber(10))
                .phoneCode("+1")
                .phoneNumber(faker.phoneNumber().subscriberNumber(10))
                .phoneVerified("true")
                .postalCode(faker.address().zipCode())
                .registrationBonus("no_bonus")
                .swift("DEUT" + faker.lorem().characters(4).toUpperCase())
                .verificationJobID(UUID.randomUUID().toString())
                .verificationSessionID(UUID.randomUUID().toString())
                .birthDate(birthDate)
                .oddsStyle("decimal")
                .password("Casino123!")
                .passwordRepeat("Casino123!")
                .registrationPromoCode("")
                .agreedWithTermsAndConditions(true)
                .agreedWithPrivacyPolicy(true)
                .agreeWithSelfExcluded(false)
                .ageConfirmed(true)
                .build();
    }

    public static AuthRequest generateValidAuthRequest() {
        return AuthRequest.builder()
                .login("danfirst69+test@gmail.com")
                .password("Casino123!")
                .useJwt(1)
                .build();
    }
}