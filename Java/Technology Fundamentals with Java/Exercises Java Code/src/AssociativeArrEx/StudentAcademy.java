package AssociativeArrEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class StudentAcademy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        LinkedHashMap<String, List<Double>> students = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = reader.readLine();
            double grade = Double.parseDouble(reader.readLine());

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);

        }

        students.entrySet()
                .stream()
                .sorted((p1, p2) -> Double.compare(
                        averageValue(p2.getValue()),
                        averageValue(p1.getValue())
                ))
                .filter(e -> averageValue(e.getValue()) >= 4.5)
                .forEach(e -> {
                    double averageGrade = averageValue(e.getValue());
                    System.out.println(String.format("%s -> %.2f", e.getKey(), averageGrade));
                });

    }

    private static double averageValue(List<Double> value) {
        return value.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .getAsDouble();
    }

}
