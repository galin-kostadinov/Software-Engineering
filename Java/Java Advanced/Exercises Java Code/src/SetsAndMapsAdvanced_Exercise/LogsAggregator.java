package SetsAndMapsAdvanced_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int sessionsCount = Integer.parseInt(reader.readLine());

        Map<String, Integer> totalSessionTimeByPerson = new TreeMap<>();
        Map<String, Set<String>> ips = new HashMap<>();

        while (sessionsCount-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            String currName = tokens[1];
            String currIp = tokens[0];
            int currTime = Integer.parseInt(tokens[2]);

            totalSessionTimeByPerson.putIfAbsent(currName, 0);
            ips.putIfAbsent(currName, new TreeSet<>());

            totalSessionTimeByPerson.put(currName, totalSessionTimeByPerson.get(currName) + currTime);
            ips.get(currName).add(currIp);
        }

        for (Map.Entry<String, Integer> kvp : totalSessionTimeByPerson.entrySet()) {
            Set<String> currIps = ips.get(kvp.getKey());
            String ipsJoined = String.join(", ", currIps);
            System.out.println(String.format("%s: %d [%s]", kvp.getKey(), kvp.getValue(), ipsJoined));
        }
    }
}
