package SetsAndMapsAdvanced_Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());
        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        while (count-- != 0) {
            String student = sc.nextLine();
            List<Double> grades = Arrays.stream(sc.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            studentsGrades.putIfAbsent(student, new ArrayList<>());
            studentsGrades.get(student).addAll(grades);
        }

        studentsGrades.forEach((student, grades) -> {
            double sumGrades = 0;
            for (Double grade : grades) {
                sumGrades += grade;
            }
            double avg = sumGrades / grades.size();
            System.out.println(String.format(
                    "%s is graduated with %s",
                    student, avg
            ));
        });
    }
}
