package SetsAndMapsAdvanced_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());

        Map<String, ArrayList<Double>> studentsAndGrades = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String student = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            studentsAndGrades.putIfAbsent(student, new ArrayList<>());
            studentsAndGrades.get(student).add(grade);
        }

        studentsAndGrades.forEach((name, grades) -> {
            String allGrades = grades.stream()
                    .map(gr -> String.format("%.2f", gr))
                    .collect(Collectors.joining(" "));

            double sumGrades = 0;
            for (Double grade : grades) {
                sumGrades += grade;
            }
            double avg = sumGrades / grades.size();

            System.out.println(
                    String.format("%s -> %s (avg: %.2f)",
                            name,
                            allGrades,
                            avg)
            );
        });
    }
}
