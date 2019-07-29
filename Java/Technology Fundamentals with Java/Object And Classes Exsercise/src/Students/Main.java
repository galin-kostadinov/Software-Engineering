package Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            double grade = Double.parseDouble(input[2]);

            Student currentStudent = new Student(firstName,lastName,grade);
            students.add(currentStudent);
        }
        students.stream()
                .sorted((p1,p2)-> Double.compare(p2.getGrade(),p1.getGrade()))
                .forEach(s-> System.out.println(s.toString()));
    }
}
