package AssociativeArrEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ForceBook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //TreeSet<String> instead List<String>; TreeSet sort alphabetically;
        LinkedHashMap<String, List<String>> forceBook = new LinkedHashMap<>();
        //key: forceSide, value: forceUsers;

        String input = "";
        while (!"Lumpawaroo".equals(input = reader.readLine())) {
            String[] token = input.split("\\s+\\|\\s+|\\s+->\\s+");

            String forceSide = input.contains("|") ? token[0] : token[1];
            String forceUser = input.contains("|") ? token[1] : token[0];

            if (input.contains("|")) {
//                final boolean[] found = {false};
//                forceBook.forEach((key, value) -> {
//                    if (value.contains(forceSide)) {
//                        found[0] = true;
//                        return
//                    }
//                });


//                if (forceBook.entrySet().stream().noneMatch(e -> e.getValue().contains(forceSide))){
//                    forceBook.get(forceSide).add(forceUser);
//                }

                boolean isContainforceUser = false;
                for (Map.Entry<String, List<String>> kvp : forceBook.entrySet()) {
                    if (kvp.getValue().contains(forceUser)) {
                        isContainforceUser = true;
                        break;
                    }
                }
                if (!isContainforceUser) {
                    forceBook.putIfAbsent(forceSide, new ArrayList<>());
                    forceBook.get(forceSide).add(forceUser);
                }
            } else {

                // forceBook.forEach((key,value)->{value.remove(forceUser);});

                for (Map.Entry<String, List<String>> kvp : forceBook.entrySet()) {
                    if (kvp.getValue().contains(forceUser)) {
                        kvp.getValue().remove(forceUser);
                        break;
                    }
                }
                forceBook.putIfAbsent(forceSide, new ArrayList<>());
                forceBook.get(forceSide).add(forceUser);
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);

            }
        }
        forceBook.entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 0)
                .sorted((p1, p2) -> {
                    int sort = Integer.compare(p2.getValue().size(), p1.getValue().size());
                    if (sort == 0) {
                        sort = p1.getKey().compareTo(p2.getKey());
                    }
                    return sort;
                })
                .forEach(e -> {
                    System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                    e.getValue().stream().sorted((e1, e2) ->
                            e1.compareTo(e2)).forEach(p -> System.out.printf("! %s%n", p));
                });
    }
}
