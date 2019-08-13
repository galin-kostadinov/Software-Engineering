package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Engine> engineList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String[] engineInput = sc.nextLine().split("\\s+");
            String model = engineInput[0];
            int power = Integer.parseInt(engineInput[1]);

            Engine engine = new Engine(model, power);

            if (engineInput.length == 4) {
                engine.setDisplacement(engineInput[2]);
                engine.setEfficiency(engineInput[3]);
            } else if (engineInput.length == 3) {
                if ((Character.isAlphabetic(engineInput[2].charAt(0)))) {
                    engine.setEfficiency(engineInput[2]);
                } else {
                    engine.setDisplacement(engineInput[2]);
                }
            }

            engineList.add(engine);
        }

        int m = Integer.parseInt(sc.nextLine());
        List<Car> carList = new ArrayList<>(m);

        for (int i = 0; i < m; i++) {
            String[] carInput = sc.nextLine().split("\\s+");
            String model = carInput[0];
            String engineModel = carInput[1];

            Engine engine = engineList
                    .stream()
                    .filter(e -> e.getModel().equals(engineModel))
                    .findFirst()
                    .get();

            Car car = new Car(model, engine);

            if (carInput.length == 4) {
                car.setWeight(carInput[2]);
                car.setColor(carInput[3]);
            } else if (carInput.length == 3) {
                if ((Character.isAlphabetic(carInput[2].charAt(0)))) {
                    car.setColor(carInput[2]);
                } else {
                    car.setWeight(carInput[2]);
                }
            }

            carList.add(car);
        }

        carList.forEach(e -> System.out.println(e.toString()));
    }
}
