import vehicle.Bus;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] carData = parseInputToDouble(reader.readLine());
        Vehicle car = new Car(carData[0], carData[1], carData[2]);

        double[] truckData = parseInputToDouble(reader.readLine());
        Vehicle truck = new Truck(truckData[0], truckData[1], truckData[2]);

        double[] busData = parseInputToDouble(reader.readLine());
        Vehicle bus = new Bus(busData[0], busData[1], busData[2]);

        Map<String, Vehicle> vehicles = new HashMap<>();

        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int lineCount = Integer.parseInt(reader.readLine());

        while (lineCount-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String output = null;
            if (tokens[0].equals("Drive")) {
                vehicles.get(tokens[1]).switchOnAdditionalConsumption();
                output = vehicles.get(tokens[1]).drive(Double.parseDouble(tokens[2]));
            } else if (tokens[0].equals("Refuel")) {
                vehicles.get(tokens[1]).switchOnAdditionalConsumption();
                try {
                    vehicles.get(tokens[1]).refuel(Double.parseDouble(tokens[2]));
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (tokens[0].equals("DriveEmpty")) {
                if (tokens[1].equals("Bus")) {
                    vehicles.get(tokens[1]).switchOffAdditionalConsumption();
                    output = vehicles.get(tokens[1]).drive(Double.parseDouble(tokens[2]));
                }
            }

            if (output != null) {
                System.out.println(output);
            }
        }

        System.out.println(vehicles.get("Car").toString());
        System.out.println(vehicles.get("Truck").toString());
        System.out.println(vehicles.get("Bus").toString());
    }

    private static double[] parseInputToDouble(String readLine) {
        return Arrays.stream(readLine.split("\\s+"))
                .skip(1)
                .mapToDouble(Double::parseDouble)
                .toArray();
    }
}
