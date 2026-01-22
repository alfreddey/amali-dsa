package org.example;

import java.util.ArrayList;
import java.util.List;

public class LicensePlateValidator {
    public static List<String> validatePlate(String plate) {
        List<String> reasons = new ArrayList<>();
        plate = plate.replaceAll("[-_\\s]", "").toUpperCase();

        if (plate.length() >= 8) {
            reasons.add(validateRegionCode(plate));
        }

        reasons.add(validateCharacterCount(plate));

        reasons.add(validateCharacterTypes(plate));

        String plateMainPart = plate.length() == 8 ? plate.substring(2) : plate;

        reasons.add(validateLetterCount(plateMainPart));

        reasons.add(validateDigitCount(plateMainPart));

        return reasons;
    }

    private static String validateRegionCode(String plate) {
        if (plate.substring(0, 2).matches("[A-Z]{2}")) {
            return "";
        }

        return "Invalid region code";
    }

    private static String validateCharacterCount(String plate) {
        if (plate.length() == 8 || plate.length() == 6) {
            return "";
        }

        return "Wrong character count";
    }

    private static String validateCharacterTypes(String plate) {
        if (plate.matches("[0-9A-Z-_\\s]+")) {
            return "";
        }

        return "Invalid characters";
    }

    private static String validateDigitCount(String plateMainPart) {
        if (plateMainPart.matches(".*[0-9].*[0-9].*")) {
            return "";
        }

        return "Insufficient digits";
    }

    private static String validateLetterCount(String plateMainPart) {
        if (plateMainPart.matches(".*[A-Z].*[A-Z].*")) {
            return "";
        }

        return "Insufficient letters";
    }
}
