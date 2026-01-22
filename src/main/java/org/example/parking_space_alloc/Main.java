package org.example.parking_space_alloc;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Parking Space Allocation System");

        System.out.println();

        Map<String, Integer> parkingSpaces = new HashMap<>();
        parkingSpaces.put("A1", 20);
        parkingSpaces.put("A2", 25);
        parkingSpaces.put("A3", 18);
        parkingSpaces.put("B1", 30);
        parkingSpaces.put("B2", 22);

        Map<String, Integer> cars = new HashMap<>();
        cars.put("CAR1", 18);
        cars.put("CAR2", 24);
        cars.put("SUV1", 16);
        cars.put("TRUCK", 28);
        cars.put("VAN", 21);

        ParkingSpaceAllocator.Result result = ParkingSpaceAllocator.allocateSpaces(parkingSpaces, cars);

        for (String allocation : result.allocations) {
            System.out.println(allocation);
        }

        System.out.println();

        System.out.println("Cars Allocated: " + result.carsAllocated);

        System.out.println();

        System.out.println("Wasted Spaces: " + result.wastedSpaces);

        System.out.println();

        System.out.println("Total Wasted Spaces: " + ParkingSpaceCalculator.calculateTotalWastedSpaces(result.wastedSpaces));
    }
}
