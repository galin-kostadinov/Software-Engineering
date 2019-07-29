package VehicleCatalogue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Vehicle> vehicles = new ArrayList<>();
        String addVehicle = "";
        while (!"End".equals(addVehicle = reader.readLine())) {
            String[] tokens = addVehicle.split("\\s+");
            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsepower = Integer.parseInt(tokens[3]);

            Vehicle currentVehicle = new Vehicle(type, model, color, horsepower);
            vehicles.add(currentVehicle);
        }

        String catalog = reader.readLine();
        while (!"Close the Catalogue".equals(catalog)) {
            String finalModel = catalog;
            vehicles.stream()
                    .filter(e -> e.getModel().equals(finalModel))
                    .forEach(v -> System.out.println(v.toString()));

            catalog = reader.readLine();
        }

        var cars = vehicles.stream()
                .filter(v -> v.getType().equals("car"))
                .collect(Collectors.toList());

        System.out.println(String.format("Cars have average horsepower of: %.2f.",average(cars)));

        var truck = vehicles.stream()
                .filter(v -> v.getType().equals("truck"))
                .collect(Collectors.toList());

        System.out.println(String.format("Trucks have average horsepower of: %.2f.",average(truck)));
    }

    public static double average(List<Vehicle> vehicles) {
        if (vehicles.size()==0){
            return 0.0;
        }
        int horsepower = 0;

        for (Vehicle vehicle : vehicles) {
            horsepower += vehicle.getHorsepower();

        }
        return 1.0 * horsepower / vehicles.size();
    }
}
