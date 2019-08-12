package FunctionalProgramming_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        String command;

        while (!"Party!".equals(command = reader.readLine())) {
            String[] tokens = command.split("\\s+");

            Predicate<String> predicate = createPredicate(tokens[1], tokens[2]);

            if (tokens[0].equals("Remove")) {
                names.removeIf(predicate);
            } else {
                List<String> nameToAdd = new ArrayList<>();

                names.forEach(name -> {
                    if (predicate.test(name)) {
                        nameToAdd.add(name);
                    }
                });

                names.addAll(nameToAdd);
            }
        }

        Collections.sort(names);

        System.out.println(names.size() == 0 ?
                "Nobody is going to the party!" :
                String.join(", ", names) + " are going to the party!");

    }

    static public Predicate<String> createPredicate(String type, String string) {
        Predicate<String> predicate;

        switch (type) {
            case "StartsWith":
                predicate = str -> str.startsWith(string);
                break;
            case "EndsWith":
                predicate = str -> str.endsWith(string);
                break;
            default:
                predicate = str -> str.length() == Integer.parseInt(string);
                break;
        }

        return predicate;
    }
}

