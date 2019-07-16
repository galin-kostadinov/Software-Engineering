package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fieldSize = Integer.parseInt(sc.nextLine());
//        if (fieldSize <= 0) {
//            while (!"end".equals(sc.nextLine())) {
//
//            }
//            System.out.println();
//            return;
//        }

        int[] field = new int[fieldSize];
        int[] ladyBugsInitialIndexes = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < ladyBugsInitialIndexes.length; i++) {
            if (ladyBugsInitialIndexes[i] >= 0 && ladyBugsInitialIndexes[i] < field.length) {
                int ladyBugIndex = ladyBugsInitialIndexes[i];
                field[ladyBugIndex] = 1;
            }
        }

        String input = "";
        while (!"end".equals(input = sc.nextLine())) {

            String[] command = input.split(" ");
            int ladybugStartIndex = Integer.parseInt(command[0]);
            String direction = command[1];
            int flyLength = Integer.parseInt(command[2]);

            if (ladybugStartIndex < 0 || ladybugStartIndex > field.length - 1
                    || field[ladybugStartIndex] == 0 || flyLength == 0) {
                continue;
            }
            int ladybugEndIndex;

            if (direction.equals("right")) {
                ladybugEndIndex = ladybugStartIndex + flyLength;
            } else {
                ladybugEndIndex = ladybugStartIndex - flyLength;
            }

            while (ladybugEndIndex >= 0 && ladybugEndIndex < field.length && field[ladybugEndIndex] == 1) {
                if (direction.equals("right")) {
                    ladybugEndIndex += flyLength;
                } else {
                    ladybugEndIndex -= flyLength;
                }
            }

            if (field[ladybugStartIndex] == 1) {
                field[ladybugStartIndex] = 0;

                if (ladybugEndIndex >= 0 && ladybugEndIndex < field.length) {
                    if (field[ladybugEndIndex] == 0) {
                        field[ladybugEndIndex] = 1;
                    }
                }
            }
        }

        for (int index : field) {
            System.out.print(index + " ");
        }
        System.out.println();
    }
}
