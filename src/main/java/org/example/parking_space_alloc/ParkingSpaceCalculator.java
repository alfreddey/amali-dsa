package org.example.parking_space_alloc;

import java.util.List;

public class ParkingSpaceCalculator {
    public static int calculateTotalWastedSpaces(List<Integer> wastedSpaces) {
        int totalWasted = 0;

        for (int wasted : wastedSpaces) {
            totalWasted += wasted;
        }

        return totalWasted;
    }
}
