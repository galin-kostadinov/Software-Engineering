package CarInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        List<Car> cars = new ArrayList<>();

        while (count-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            if (tokens.length > 1) {
                String make = tokens[0];
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                Car car = new Car(make, model, horsePower);
                cars.add(car);

            } else {
                String make = tokens[0];
                Car car = new Car(make);
                cars.add(car);
            }

        }

        cars.forEach(car -> System.out.println(car.carInfo()));
    }
}
