package softUniParking;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    Map<String, Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.capacity = capacity;
        cars = new LinkedHashMap<>();
    }

    public String addCar(Car car) {
        if (cars.containsKey(car.getRegistrationNumber())) {
            return "Car with that registration number, already exists!";
        } else if (this.capacity <= cars.size()) {
            return "Parking is full!";
        }

        cars.put(car.getRegistrationNumber(), car);

        return String.format("Successfully added new car %s %s", car.getMake(), car.getRegistrationNumber());
    }

    public String removeCar(String registrationNumber) {
        if (!cars.containsKey(registrationNumber)) {
            return "Car with that registration number, doesn't exists!";
        }

        cars.remove(registrationNumber);

        return String.format("Successfully removed %s", registrationNumber);
    }

    public Car getCar(String registrationNumber) {
        return cars.get(registrationNumber);
    }

    public void removeSetOfRegistrationNumber(List<String> registrationNumbers) {
        StringBuilder sb = new StringBuilder();
        for (String registrationNumber : registrationNumbers) {
           removeCar(registrationNumber);
        }
    }

    public int getCount() {
        return cars.size();
    }
}
