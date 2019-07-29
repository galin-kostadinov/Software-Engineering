package OrderByAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();
        String input = "";

        while (!"End".equals(input = reader.readLine())) {
            String[] token = input.split("\\s+");
            String name = token[0];
            String id = token[1];
            int age = Integer.parseInt(token[2]);

            Person person = new Person(name, id, age);
            people.add(person);
        }
        people.stream().sorted((p1,p2)-> Integer.compare(p1.getAge(),p2.getAge()))
                .forEach(e-> System.out.println(e.toString()));
    }
}
