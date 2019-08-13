package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] input = sc.nextLine().split("\\s++".trim());
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);

            Engine engine = new Engine(enginePower, engineSpeed);
            Cargo cargo = new Cargo(cargoType, cargoWeight);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);
            Car car = new Car(model, engine, cargo, tire1, tire2, tire3, tire4);
            cars.add(car);
        }

        String command = sc.nextLine();
        if (command.equals("fragile")) {
            cars.stream()
                    .filter(car -> car.getCargo().getType().equals("fragile")
                            && (car.getTire1().getPressure() < 1
                            || car.getTire2().getPressure() < 1
                            || car.getTire3().getPressure() < 1
                            || car.getTire4().getPressure() < 1))
                    .forEach(car -> System.out.printf("%s%n", car.getModel()));
        } else if (command.equals("flamable")) {
            cars.stream()
                    .filter(car -> car.getCargo().getType().equals("flamable")
                            && car.getEngine().getPower() > 250)
                    .forEach(car -> System.out.printf("%s%n", car.getModel()));
        }
    }
}
