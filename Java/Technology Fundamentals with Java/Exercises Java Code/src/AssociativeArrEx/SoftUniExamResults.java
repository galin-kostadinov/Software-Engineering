package AssociativeArrEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class SoftUniExamResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> studentsPoints = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> languageSubmissionsCount = new LinkedHashMap<>();

        String input = "";
        while (!"exam finished".equals(input = reader.readLine())) {
            String[] token = input.split("-");
            String studentName = token[0];

            if (token[1].equals("banned")) {
                if (studentsPoints.containsKey(studentName)) {
                    studentsPoints.remove(studentName);
                }
            } else {
                String language = token[1];
                int points = Integer.parseInt(token[2]);

                if (!studentsPoints.containsKey(studentName)) {
                    studentsPoints.put(studentName, points);
                } else if (studentsPoints.get(studentName) < points) {
                    studentsPoints.put(studentName, points);
                }

                if (!languageSubmissionsCount.containsKey(language)) {
                    languageSubmissionsCount.put(language, 0);
                }
                languageSubmissionsCount.put(language, languageSubmissionsCount.get(language) + 1);
            }
        }

        System.out.println("Results:");
        studentsPoints.entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int sort = Integer.compare(p2.getValue(), p1.getValue());

                    if (sort == 0) {
                        sort = p1.getKey().compareTo(p2.getKey());
                    }
                    return sort;
                })
                .forEach(e-> System.out.printf("%s | %d%n",e.getKey(),e.getValue()));

        System.out.println("Submissions:");
        languageSubmissionsCount.entrySet().stream()
                .sorted((p1, p2) -> {
                    int sort = Integer.compare(p2.getValue(), p1.getValue());

                    if (sort == 0) {
                        sort = p1.getKey().compareTo(p2.getKey());
                    }
                    return sort;
                })
                .forEach(e-> System.out.printf("%s - %d%n",e.getKey(),e.getValue()));
    }
}
