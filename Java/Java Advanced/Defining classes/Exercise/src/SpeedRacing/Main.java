package SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        Map<String, Car> carMap = new LinkedHashMap<>();

        while (count-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double FuelCostFor1km = Double.parseDouble(tokens[2]);

            carMap.putIfAbsent(model, new Car(model, fuelAmount, FuelCostFor1km));
        }

        String input;

        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");

            String carModel = tokens[1];
            double amountOfKm = Double.parseDouble(tokens[2]);

            Car car = carMap.get(carModel);
            if (car != null) {
                car.setDistanceTraveled(amountOfKm);
            }
        }

        carMap.forEach((key, value) -> System.out.println(String.format("%s %.2f %.0f",
                key,
                value.getFuelAmount(),
                value.getDistanceTraveled())));
    }
}
