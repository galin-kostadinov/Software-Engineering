package CarSalesmanMoreEx;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Engine> engineList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String[] engineInput = sc.nextLine().split("\\s+");
            String model = engineInput[0];
            int power = Integer.parseInt(engineInput[1]);
            String displacement = "n/a";
            String efficiency = "n/a";

            if (engineInput.length == 4) {
                displacement = engineInput[2];
                efficiency = engineInput[3];
            } else if (engineInput.length == 3) {
                if ((Character.isAlphabetic(engineInput[2].charAt(0)))) {
                    efficiency = engineInput[2];
                } else {
                    displacement = engineInput[2];
                }
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engineList.add(engine);
        }

        int m = Integer.parseInt(sc.nextLine());
        List<Car> carList = new ArrayList<>(m);

        for (int i = 0; i < m; i++) {
            String[] carInput = sc.nextLine().split("\\s+");
            String model = carInput[0];
            String engineModel = carInput[1];
            String weight = "n/a";
            String color = "n/a";

            if (carInput.length == 4) {
                weight = carInput[2];
                color = carInput[3];
            } else if (carInput.length == 3) {
                if ((Character.isAlphabetic(carInput[2].charAt(0)))) {
                    color = carInput[2];
                } else {
                    weight = carInput[2];
                }
            }

            Engine engine = engineList
                    .stream()
                    .filter(e -> e.getModel().equals(engineModel))
                    .findFirst()
                    .get();

            Car car = new Car(model, engine, weight, color);
            carList.add(car);
        }

        // Collections.reverse(carList);

        carList.forEach(e -> System.out.println(e.toString()));
    }
}
