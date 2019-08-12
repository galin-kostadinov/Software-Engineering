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
            String make = tokens[0];
            String model = tokens[1];
            int horsePower = Integer.parseInt(tokens[2]);

            Car car = new Car();
            car.setModel(model);
            car.setMake(make);
            car.setHorsePower(horsePower);

            cars.add(car);
        }

        cars.forEach(car -> System.out.println(car.carInfo()));
    }
}
