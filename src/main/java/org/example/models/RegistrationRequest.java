package org.example.models;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class RegistrationRequest {
    private String address;
    private String bankName;
    private String bankNameText;
    private String birthDay;
    private String birthMonth;
    private String birthYear;
    private String branchCode;
    private String city;
    private String countryCode;
    private String currency;
    private String email;
    private String emailVerified;
    private Map<String, Object> extProfile;
    private String firstName;
    private String gender;
    private String ibanNumber;
    private String idNumber;
    private String idUser;
    private String lastName;
    private String login;
    private String newEmail;
    private String phoneAltCode;
    private String phoneAltNumber;
    private String phoneCode;
    private String phoneNumber;
    private String phoneVerified;
    private String postalCode;
    private String registrationBonus;
    private String swift;
    private String verificationJobID;
    private String verificationSessionID;
    private String birthDate;
    private String oddsStyle;
    private String password;
    private String registrationPromoCode;
    private boolean agreedWithTermsAndConditions;
    private boolean agreedWithPrivacyPolicy;
    private boolean agreeWithSelfExcluded;
    private boolean ageConfirmed;
    private String passwordRepeat;
}