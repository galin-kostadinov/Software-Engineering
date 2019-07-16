package AssociativeArrEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class CompanyUsers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, List<String>> employees = new LinkedHashMap<>();

        String input = "";
        while (!"End".equals(input = reader.readLine())) {
            String[] token = input.split(" -> ");
            String company = token[0];
            String employee = token[1];
            employees.putIfAbsent(company, new ArrayList<String>());
            if (!employees.get(company).contains(employee)) {
                employees.get(company).add(employee);
            }
        }

        employees.entrySet()
                .stream()
                .sorted((p1, p2) -> p1.getKey().compareTo(p2.getKey()))
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().forEach(p -> System.out.printf("-- %s%n",p));
                });
    }
}
