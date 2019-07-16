package AssociativeArrEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class SoftUniParking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int commandCount = Integer.parseInt(reader.readLine());

        LinkedHashMap<String, String> parkingLot = new LinkedHashMap<>();

        for (int i = 0; i < commandCount; i++) {
            String[] token = reader.readLine().split("\\s+");
            String command = token[0];
            String username = token[1];

            if (command.equals("register")) {
                String licensePlateNumber = token[2];
                if (!parkingLot.containsKey(username)) {

                    parkingLot.put(username, licensePlateNumber);
                    System.out.println(String.format(
                            "%s registered %s successfully",
                            username, licensePlateNumber));
                } else {
                    System.out.println(String.format(
                            "ERROR: already registered with plate number %s",
                            licensePlateNumber));
                }

            } else {
                if (!parkingLot.containsKey(username)) {
                    System.out.println(String.format("ERROR: user %s not found",
                            username));
                } else {
                    parkingLot.remove(username);
                    System.out.println(String.format(
                            "%s unregistered successfully",
                            username));
                }
            }
        }
        parkingLot.entrySet().forEach(e ->
                System.out.println(String.format("%s => %s",
                        e.getKey(), e.getValue())));

    }
}
