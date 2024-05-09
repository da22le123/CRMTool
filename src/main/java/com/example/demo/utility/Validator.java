package com.example.demo.utility;

import lombok.experimental.UtilityClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class Validator {
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Creating a Pattern object
        Pattern pattern = Pattern.compile(emailRegex);

        // Matching the given email with the pattern
        Matcher matcher = pattern.matcher(email);

        // Returning true if email matches the pattern, otherwise false
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Check if the phone number starts with '6' and has a length of 9
        return phoneNumber.startsWith("6") && phoneNumber.length() == 9 && isNumeric(phoneNumber);
    }

    public static boolean isValidPostalCode(String postalCode) {
        // Regular expression to match the desired format: 0000 AA
        String regex = "\\d{4}\\s[A-Za-z]{2}";

        // Validate the postal code against the regex
        return postalCode.matches(regex);
    }



    private boolean isNumeric(String str) {
        // Check if the string contains only numeric characters
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
