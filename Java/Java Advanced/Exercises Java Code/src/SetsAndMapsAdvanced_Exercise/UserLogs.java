package SetsAndMapsAdvanced_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> userLogs = new TreeMap<>();
        String line = "";

        while (!"end".equals(line = reader.readLine())) {

            String currIp = line.substring(line.indexOf('=') + 1, line.indexOf(' '));
            String currName = line.substring(line.lastIndexOf('=') + 1);

            userLogs.putIfAbsent(currName, new LinkedHashMap<>());

            Map<String, Integer> currIpsMap = userLogs.get(currName);

            currIpsMap.putIfAbsent(currIp, 0);

            currIpsMap.put(currIp, currIpsMap.get(currIp) + 1);
        }

        for (Map.Entry<String, Map<String, Integer>> kvp : userLogs.entrySet()) {
            String username = kvp.getKey();
            Map<String, Integer> currIpsMap = kvp.getValue();

            Set<String> ipsCount = new LinkedHashSet<>();

            currIpsMap.forEach((key, value) -> ipsCount.add(String.format("%s => %d", key, value)));

            String ipsCountToPrint = String.join(", ",ipsCount);

            System.out.println(username + ":");

            System.out.println(ipsCountToPrint + ".");
        }
    }
}
