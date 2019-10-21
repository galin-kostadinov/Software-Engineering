package PetClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int commandCount = Integer.parseInt(reader.readLine());
        Map<String, Pet> petMap = new HashMap<>();
        Map<String, Clinic> clinicMap = new HashMap<>();

        for (int i = 0; i < commandCount; i++) {
            String[] token = reader.readLine().split("\\s++");

            String command = token[0];
            if (command.equals("Create")) {
                if (token[1].equals("Pet")) {
                    String name = token[2];
                    int age = Integer.parseInt(token[3]);
                    String kind = token[4];

                    petMap.putIfAbsent(name, new Pet(name, age, kind));
                } else if (token[1].equals("Clinic")) {
                    String name = token[2];
                    int rooms = Integer.parseInt(token[3]);

                    if (rooms % 2 != 0) {
                        clinicMap.putIfAbsent(name, new Clinic(name, rooms));
                    } else {
                        System.out.println("Invalid Operation!");
                    }
                }
            } else if (command.equals("Add")) {
                String petName = token[1];
                String clinicName = token[2];

                if (clinicMap.containsKey(clinicName) && petMap.containsKey(petName)) {
                    System.out.println(clinicMap.get(clinicName).add(petMap.get(petName)));
                } else {
                    System.out.println(false);
                }
            } else if (command.equals("Release")) {
                String clinicName = token[1];
                if (clinicMap.containsKey(clinicName)) {
                    System.out.println(clinicMap.get(clinicName).release());
                } else {
                    System.out.println(false);
                }
            } else if (command.equals("HasEmptyRooms")) {
                String clinicName = token[1];
                if (clinicMap.containsKey(clinicName)) {
                    System.out.println(clinicMap.get(clinicName).HasEmptyRooms());
                } else {
                    System.out.println(false);
                }
            } else if (command.equals("Print")) {
                String clinicName = token[1];

                if (token.length == 2) {
                    if (clinicMap.containsKey(clinicName)) {
                        clinicMap.get(clinicName).print();
                    }
                } else {
                    int room = Integer.parseInt(token[2]);

                    if (clinicMap.containsKey(clinicName)) {
                        clinicMap.get(clinicName).print(room);
                    }
                }
            }
        }
    }
}
