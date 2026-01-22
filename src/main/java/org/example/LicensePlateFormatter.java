package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class LicensePlateFormatter {
    public static void printFormattedPlate(int count, String plate) {
        plate = plate.replaceAll("[-_\\s]", "").toUpperCase();

        StringBuilder formattedPlate = new StringBuilder();

        if (plate.length() == 8) {
            formattedPlate
                    .append(plate, 0, 2)
                    .append("-")
                    .append(plate, 2, 5)
                    .append("-")
                    .append(plate, 5, 8);
        } else {
            formattedPlate
                    .append(plate, 0, 3)
                    .append("-")
                    .append(plate, 3, 6);
        }

        System.out.printf("Plate %d: %s", count, formattedPlate);
    }

    public static void printReasons(int count, List<String> reasons) {
        reasons = reasons.stream().filter(reason -> !reason.isEmpty()).toList();

        System.out.printf("Plate %d: Invalid", count);
        System.out.println();
        System.out.println("Reasons: " + reasons);
    }
}
