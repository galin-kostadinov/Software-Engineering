package AssociativeArrEx;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Courses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, List<String>> studentsPerCourse = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> studentCountPerCourse = new LinkedHashMap<>();

        String input = "";
        while (!"end".equals(input = sc.nextLine())) {
            String[] token = input.split(" : ");
            String courseName = token[0];
            String studentName = token[1];

            if (!studentsPerCourse.containsKey(courseName)) {
                List<String> students = new ArrayList<>();
                studentsPerCourse.put(courseName, students);
                studentCountPerCourse.put(courseName, 0);
            }
            studentsPerCourse.get(courseName).add(studentName);
            studentCountPerCourse.put(courseName, studentCountPerCourse.get(courseName) + 1);
        }


        studentCountPerCourse.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue(), e1.getValue());
//                    if (sort == 0) {
//                        sort = e1.getKey().compareTo(e2.getKey());
//                    }
                    return sort;
                })
                .forEach(e -> {
                    String courseName = e.getKey();
                    int studentsCount = e.getValue();

                    System.out.println(String.format("%s: %d", courseName, studentsCount));

                    studentsPerCourse
                            .get(courseName)
                            .stream()
                            .sorted((p1, p2) -> p1.compareTo(p2))
                            .forEach(el -> System.out.printf("-- %s%n", el));

                });

    }
}
