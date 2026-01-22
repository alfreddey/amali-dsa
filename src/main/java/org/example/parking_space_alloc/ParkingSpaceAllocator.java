package org.example.parking_space_alloc;

import java.util.*;

public class ParkingSpaceAllocator {
    public static class Result {
        public int carsAllocated;
        public List<String> allocations;
        public List<Integer> wastedSpaces;

        public Result(int carsAllocated, List<String> allocations, List<Integer> wastedSpaces) {
            this.carsAllocated = carsAllocated;
            this.allocations = allocations;
            this.wastedSpaces = wastedSpaces;
        }
    }

    public static Result allocateSpaces(Map<String, Integer> parkingSpaces, Map<String, Integer> cars) {
        Map<Integer, String> invertedParkingSpaces = invertMap(parkingSpaces);
        Map<Integer, String> invertedCars = invertMap(cars);

        Integer[] sortedParkingSizes = invertedParkingSpaces.keySet().toArray(Integer[]::new);
        Integer[] sortedCarSizes = invertedCars.keySet().toArray(Integer[]::new);

        sort(sortedParkingSizes);
        sort(sortedCarSizes);

        List<String> allocations = new ArrayList<>();
        List<Integer> wastedSpaces = new ArrayList<>();
        int carsAllocated = 0;

        int i = 0, j = 0;

        while (i < sortedParkingSizes.length) {
            int carSize = sortedCarSizes[j];
            int parkingSize = sortedParkingSizes[i];

            if (parkingSize >= carSize) {
                String carId = invertedCars.get(carSize);
                String parkingId = invertedParkingSpaces.get(parkingSize);

                allocations.add("Car " + carId + " allocated to Parking Space " + parkingId);
                wastedSpaces.add(parkingSize - carSize);
                carsAllocated++;

                j++;

                if (j >= sortedCarSizes.length) {
                    break;
                }
            } else {
                wastedSpaces.add(parkingSize);
            }

            i++;
        }

        return new Result(carsAllocated, allocations, wastedSpaces);
    }

    private static void sort(Integer[] list) {
        Arrays.sort(list);
    }

    private static Map<Integer, String> invertMap(Map<String, Integer> map) {
        Map<Integer, String> newMap = new HashMap<>();

        for (var entry : map.entrySet()) {
            newMap.put(entry.getValue(), entry.getKey());
        }

        return newMap;
    }
}
