import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carData = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));

        String[] truckData = reader.readLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]));

        Map<String, Vehicle> vehicles = new HashMap<>();

        vehicles.put("Car", car);
        vehicles.put("Truck", truck);

        int lineCount = Integer.parseInt(reader.readLine());

        while (lineCount-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String output = null;
            if (tokens[0].equals("Drive")) {
                output = vehicles.get(tokens[1]).drive(Double.parseDouble(tokens[2]));
            } else if (tokens[0].equals("Refuel")) {
                vehicles.get(tokens[1]).refuel(Double.parseDouble(tokens[2]));
            }

            if (output!=null){
                System.out.println(output);
            }
        }

        System.out.println(vehicles.get("Car").toString());
        System.out.println(vehicles.get("Truck").toString());
    }
}
