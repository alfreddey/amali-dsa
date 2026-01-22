package org.example;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of license plates to process: ");

        String number = scanner.nextLine();

        int plateCount = Integer.parseInt(number);

        while (plateCount > 0) {
            System.out.print("Enter license plate: ");
            String plate = scanner.nextLine();

            var reasons = LicensePlateValidator.validatePlate(plate);

            if (reasons.stream().allMatch(String::isEmpty)) {
                LicensePlateFormatter.printFormattedPlate(Integer.parseInt(number) - plateCount + 1, plate);
            } else {
                LicensePlateFormatter.printReasons(Integer.parseInt(number) - plateCount + 1, reasons);
            }

            System.out.println();

            plateCount--;
        }
    }
}
