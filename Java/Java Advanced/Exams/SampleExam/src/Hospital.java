import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hospital {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final int departmentRoomsCount = 20;
        final int roomCapacity = 3;

        String input;

        Map<String, ArrayList<ArrayList<String>>> departments = new HashMap<>();
        Map<String, ArrayList<String>> doctors = new HashMap<>();

        while (!"Output".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s++");

            String department = tokens[0];
            String doctor = tokens[1] + " " + tokens[2];
            String patient = tokens[3];

            departments.putIfAbsent(department, new ArrayList<>());
            doctors.putIfAbsent(doctor, new ArrayList<>());

            ArrayList<ArrayList<String>> currentDepartment = departments.get(department);
            if (currentDepartment.isEmpty()) {
                ArrayList<String> room = new ArrayList<>();
                room.add(patient);
                currentDepartment.add(room);
            } else {
                ArrayList<String> lastRoom = currentDepartment.get(currentDepartment.size() - 1);
                if (lastRoom.size() < roomCapacity) {
                    lastRoom.add(patient);
                } else if (currentDepartment.size() < departmentRoomsCount) {
                    ArrayList<String> newRoom = new ArrayList<>();
                    newRoom.add(patient);
                    currentDepartment.add(newRoom);
                }
            }

            if (!doctors.get(doctor).contains(patient)) {
                doctors.get(doctor).add(patient);
            }
        }

        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s++");

            if (tokens.length == 1) {
                String department = tokens[0];
                printAllDepartment(departments, department);
            } else if (Character.isDigit(tokens[1].charAt(0))) {
                String department = tokens[0];
                int room = Integer.parseInt(tokens[1]);

                printDepartmentRoom(departments, department, room);
            } else {
                String doctor = tokens[0] + " " + tokens[1];
                printDoctorPatient(doctors, doctor);
            }
        }
    }

    private static void printDoctorPatient(Map<String, ArrayList<String>> doctors, String doctor) {
        doctors.get(doctor).stream().sorted().forEach(System.out::println);
    }

    private static void printDepartmentRoom(Map<String, ArrayList<ArrayList<String>>> departments,
                                            String department, int room) {
        departments.get(department).get(room - 1).stream().sorted().forEach(System.out::println);
    }

    private static void printAllDepartment(Map<String, ArrayList<ArrayList<String>>> departments, String department) {
        departments.get(department).forEach(rooms -> rooms.forEach(System.out::println));
    }
}