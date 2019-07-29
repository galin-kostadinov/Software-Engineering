package CompanyRosterMoreEx;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());

        Map<String, List<Employee>> employeesByDepartment = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String[] token = sc.nextLine().split("\\s+");
            String name = token[0];
            double salary = Double.parseDouble(token[1]);
            String position = token[2];
            String department = token[3];
            String email = "n/a";
            int age = -1;

            if (token.length > 5) {
                email = token[4];
                age = Integer.parseInt(token[5]);
            } else if (token.length > 4) {
                if (token[4].contains("@")) {
                    email = token[4];
                } else {
                    age = Integer.parseInt(token[4]);
                }
            }

            Employee currentEmployee = new Employee(name, salary, position, department, email, age);

            if (!employeesByDepartment.containsKey(department)) {
                List<Employee> employees = new ArrayList<>();
                employees.add(currentEmployee);
                employeesByDepartment.put(department, employees);
            } else {
                List<Employee> employees = employeesByDepartment.get(department);
                employees.add(currentEmployee);
            }
        }

        String departmentMaxSalary = departmentWithMaxAverageSalary(employeesByDepartment);

        System.out.println("Highest Average Salary: " + departmentMaxSalary);
        employeesByDepartment.entrySet()
                .stream()
                .filter(e->e.getKey().equals(departmentMaxSalary))
                .forEach(e->{
                    List<Employee> employees= e.getValue();
                    employees.stream()
                            .sorted((e1,e2)->Double.compare(e2.getSalary(), e1.getSalary()))
                            .forEach(x-> System.out.printf("%s %.2f %s %d%n",
                                    x.getName(), x.getSalary(), x.getEmail(),x.getAge()));
                });
    }

    private static String departmentWithMaxAverageSalary(Map<String, List<Employee>> employeesByDepartment) {
        Map<Double, String> averageSalaryByDepartment = new HashMap<>();

        for (Map.Entry<String, List<Employee>> stringListEntry : employeesByDepartment.entrySet()) {
            String currentDepartment = stringListEntry.getKey();
            List<Employee> currentEmployees = stringListEntry.getValue();

            double salarySum = 0;
            for (Employee employee : currentEmployees) {
                salarySum += employee.getSalary();
            }
            double averageSalary = salarySum / currentEmployees.size();
            averageSalaryByDepartment.put(averageSalary, currentDepartment);
        }

        double maxAverageSalary = averageSalaryByDepartment.keySet()
                .stream()
                .max((a, b) -> Double.compare(a, b))
                .get();

        return  averageSalaryByDepartment.get(maxAverageSalary);
    }
}