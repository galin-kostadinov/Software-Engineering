package FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque inputQueue = new ArrayDeque();
        String nameOrBirthday = reader.readLine();

        Map<String, Person> people = new HashMap<>();

        String input;

        while (!"End".equals(input = reader.readLine())) {
            if (!input.contains("-")) {
                String name = input.substring(0, input.lastIndexOf(" "));
                String birthday = input.substring(input.lastIndexOf(" ") + 1);
                Person person = new Person(name, birthday);
                people.putIfAbsent(name, person);
            } else {
                inputQueue.offer(input);
            }
        }

        List<Person> parents = new ArrayList<>();
        List<Person> children = new ArrayList<>();

        String namePerson = "";
        String birthdayPerson = "";

        if (Character.isDigit(nameOrBirthday.charAt(0))) {
            birthdayPerson = nameOrBirthday;
        } else {
            namePerson = nameOrBirthday;
        }

        if (namePerson.isEmpty()) {
            for (Person person : people.values()) {
                if (person.getBirthday().equals(birthdayPerson)) {
                    namePerson = person.getName();
                    break;
                }
            }
        } else {
            birthdayPerson = people.get(namePerson).getBirthday();
        }

        while (!inputQueue.isEmpty()) {
            String currentInput = inputQueue.poll().toString();

            String firstPart = currentInput.split("-")[0].trim();
            String secondPart = currentInput.split("-")[1].trim();

            if (Character.isDigit(firstPart.charAt(0)) && Character.isDigit(secondPart.charAt(0))) {
                String parentBirthday = firstPart;
                String childBirthday = secondPart;

                if (birthdayPerson.equals(parentBirthday)) {
                    Person child = getPersonByBirthday(people, childBirthday);
                    children.add(child);
                } else if (birthdayPerson.equals(childBirthday)) {
                    Person parent = getPersonByBirthday(people, parentBirthday);
                    parents.add(parent);
                }
            } else if (Character.isDigit(firstPart.charAt(0)) && !Character.isDigit(secondPart.charAt(0))) {
                String parentBirthday = firstPart;
                String childName = secondPart;

                if (birthdayPerson.equals(parentBirthday)) {
                    children.add(people.get(childName));
                } else if (namePerson.equals(childName)) {
                    parents.add(getPersonByBirthday(people, parentBirthday));
                }
            } else if (!Character.isDigit(firstPart.charAt(0)) && Character.isDigit(secondPart.charAt(0))) {
                String parentName = firstPart;
                String childBirthday = secondPart;

                if (birthdayPerson.equals(childBirthday)) {
                    parents.add(people.get(parentName));
                } else if (namePerson.equals(parentName)) {
                    children.add(getPersonByBirthday(people, childBirthday));
                }
            } else {
                String parentName = firstPart;
                String childName = secondPart;

                if (namePerson.equals(childName)) {
                    parents.add(people.get(parentName));
                } else if (namePerson.equals(parentName)) {
                    children.add(people.get(childName));
                }
            }
        }

        System.out.println(namePerson + " " + birthdayPerson);
        System.out.println("Parents:");
        parents.forEach(p -> {
            System.out.println(p.getName() + " " + p.getBirthday());
        });
        System.out.println("Children:");
        children.forEach(p -> {
            System.out.println(p.getName() + " " + p.getBirthday());
        });
    }

    private static Person getPersonByBirthday(Map<String, Person> people, String birthday) {
        for (Person person : people.values()) {
            if (person.getBirthday().equals(birthday)) {
                return person;

            }
        }

        return null;
    }
}
