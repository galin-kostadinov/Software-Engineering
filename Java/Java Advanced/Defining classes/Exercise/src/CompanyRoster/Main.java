package CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        Map<String, Department> departmentMap = new HashMap<>();

        while (count-- > 0) {
            String[] token = reader.readLine().split("\\s+");

            String name = token[0];
            double salary = Double.parseDouble(token[1]);
            String position = token[2];
            String departmentName = token[3];

            Employee employee = new Employee(name, salary, position);

            if (token.length == 6) {
                employee.setEmail(token[4]);
                employee.setAge(Integer.parseInt(token[5]));
            } else if (token.length == 5) {
                if (token[4].contains("@")) {
                    employee.setEmail(token[4]);
                } else {
                    employee.setAge(Integer.parseInt(token[4]));
                }
            }

            if (!departmentMap.containsKey(departmentName)) {
                departmentMap.put(departmentName, new Department());
            }

            departmentMap.get(departmentName).addEmployee(employee);
        }

        Map.Entry<String, Department> departmentMaxSalary = departmentMap.entrySet().stream()
                .sorted((f, s) -> Double.compare(s.getValue().getAverageSalary(), f.getValue().getAverageSalary()))
                .findFirst()
                .get();


        System.out.println("Highest Average Salary: " + departmentMaxSalary.getKey());

        departmentMaxSalary.getValue()
                .getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(emp -> System.out.printf("%s %.2f %s %d%n",
                        emp.getName(), emp.getSalary(), emp.getEmail(), emp.getAge())
                );

    }
}
