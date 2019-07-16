package FinalExam14April2019GroupI;

import java.util.*;

public class OnTheWayToAnnapurna {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> storeItems = new LinkedHashMap<>();
        String input = "";
        while (!"END".equals(input = sc.nextLine())) {
            String[] token = input.split("\\s*->\\s*");
            String command = token[0];
            String store = token[1];
            if (command.equals("Add")) {
                String[] itemInput = token[2].split(",");
                if (!storeItems.containsKey(store)) {
                    List<String> items = new ArrayList<>();
                    items.addAll(Arrays.asList(itemInput));
                    storeItems.put(store, items);
                } else {
                    List<String> items = storeItems.get(store);
                    items.addAll(Arrays.asList(itemInput));
                    storeItems.put(store, items);
                }
            } else if (command.equals("Remove")) {
                storeItems.remove(store);
            }

        }
        System.out.println("Stores list:");
        storeItems.entrySet()
                .stream()
                .sorted((kvp1, kvp2) -> {
                    List<String> firstListItems = kvp1.getValue();
                    List<String> secondListItemss = kvp2.getValue();

                    int sort = Integer.compare(secondListItemss.size(), firstListItems.size());

                    if (sort == 0) {
                        sort = kvp2.getKey().compareTo(kvp1.getKey());
                    }
                    return sort;
                })
                .forEach(kvp -> {
                    String currentStore = kvp.getKey();
                    List<String> currentItems = kvp.getValue();
                    System.out.println(currentStore);
                    currentItems.forEach(e -> System.out.printf("<<%s>>%n", e));
                });


    }
}
