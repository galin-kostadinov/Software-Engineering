package healthyHeaven;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Restaurant {
    private String name;
    private Map<String, Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public void add(Salad salad) {
        this.data.putIfAbsent(salad.getName(), salad);
    }

    public boolean buy(String name) {
        if (data.containsKey(name)) {
            data.remove(name);
            return true;
        }
        return false;
    }

    public Salad getHealthiestSalad() {
        Map.Entry<String, Salad> minCal = data.entrySet()
                .stream()
                .min((a, b) -> Integer.compare(a.getValue().getTotalCalories(), b.getValue().getTotalCalories()))
                .get();

        return minCal.getValue();
    }

    public String generateMenu() {
        String line = String.format("%s have %d salads:", this.getName(), this.data.size());

        StringBuilder sb = new StringBuilder();
        sb.append(line).append(System.lineSeparator());

        for (Salad salad : data.values()) {
            sb.append(salad).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
