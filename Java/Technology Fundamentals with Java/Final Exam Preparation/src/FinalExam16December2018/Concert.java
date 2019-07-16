package FinalExam16December2018;

import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> bandsMembers = new LinkedHashMap<>();
        Map<String, Integer> bandsTime = new LinkedHashMap<>();

        String input = "";
        while (!"start of concert".equals(input = sc.nextLine())) {
            String[] token = input.split("\\s*;\\s*");
            String command = token[0];
            String bandName = token[1];
            if (command.equals("Add")) {
                String[] currentMembers = token[2].split("\\s*,\\s*".trim());
                if (!bandsMembers.containsKey(bandName)) {
                    bandsMembers.put(bandName, new ArrayList<>());
                }
                addMembers(bandsMembers, bandName, currentMembers);
            } else if (command.equals("Play")) {
                int time = Integer.parseInt(token[2]);
                if (!bandsTime.containsKey(bandName)) {
                    bandsTime.put(bandName, time);
                } else {
                    bandsTime.put(bandName, bandsTime.get(bandName) + time);
                }
            }
        }
        int totalTime = bandsTime.values().stream().mapToInt(Integer::intValue).sum();
        System.out.printf("Total time: %d%n", totalTime);
        bandsTime.entrySet()
                .stream()
                .sorted((b1, b2) -> {
                    int sort = Integer.compare(b2.getValue(), b1.getValue());
                    if (sort == 0) {
                        sort = b1.getKey().compareTo(b2.getKey());
                    }
                    return sort;
                })
                .forEach(band -> System.out.printf("%s -> %d%n", band.getKey(), band.getValue()));

        String printBandMembers = sc.nextLine();
        System.out.println(printBandMembers);
        bandsMembers.entrySet()
                .stream()
                .filter(band -> band.getKey().equals(printBandMembers))
                .forEach(band -> {
                            band.getValue().forEach(m -> System.out.printf("=> %s%n", m));
                        }
                );


    }

    private static void addMembers(Map<String, List<String>> bandsMembers,
                                   String bandName,
                                   String[] currentMembers) {
        List<String> members = bandsMembers.get(bandName);
        for (int i = 0; i < currentMembers.length; i++) {
            String memberName = currentMembers[i];
            if (!members.contains(memberName)) {
                members.add(memberName);
            }
        }
    }
}
