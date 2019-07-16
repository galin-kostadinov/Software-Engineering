package MethodExercise;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayManipulator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = "";
        while (!"end".equals(input = reader.readLine())) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if (command.equals("exchange")) {
                int splittedIndex = Integer.parseInt(tokens[1]);
                if (splittedIndex > numbers.length - 1 || splittedIndex < 0) {
                    System.out.println("Invalid index");
                    continue;
                }
                exchange(numbers, splittedIndex);

            } else if (command.equals("max")) {
                String oddEven = tokens[1];
                int index = elementIndex(numbers, oddEven, "max");
                if (index != -1) {
                    System.out.println(index);
                } else {
                    System.out.println("No matches");
                }
            } else if (command.equals("min")) {
                String oddEven = tokens[1];
                int index = elementIndex(numbers, oddEven, "min");
                if (index != -1) {
                    System.out.println(index);
                } else {
                    System.out.println("No matches");
                }
            } else if (command.equals("first")) {
                int count = Integer.parseInt(tokens[1]);
                String oddEven = tokens[2];
                firstElement(numbers, count, oddEven);

            } else if (command.equals("last")) {
                int count = Integer.parseInt(tokens[1]);
                String oddEven = tokens[2];
                lastElement(numbers, count, oddEven);
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

    private static void lastElement(int[] numbers, int count, String oddEven) {
        if (count > numbers.length) {
            System.out.println("Invalid count");
            return;
        }

        int realCount = 0;
        int condition = "even".equals(oddEven) ? 0 : 1;
        for (int i = 0; realCount < count && i < numbers.length; i++) {
            if (numbers[numbers.length - 1 - i] % 2 == condition) {
                realCount++;
            }
        }
        if (realCount < 1) {
            System.out.println("[]");
            return;
        }
        int[] currentNum = new int[realCount];
        int index = realCount - 1;
        realCount = 0;
        for (int i = 0; realCount < count && i < numbers.length; i++) {
            if (numbers[numbers.length - 1 - i] % 2 == condition) {
                currentNum[index--] = numbers[numbers.length - 1 - i];
                realCount++;
            }
        }

        System.out.println(Arrays.toString(currentNum));
    }


    private static void firstElement(int[] numbers, int count, String oddEven) {
        if (count > numbers.length) {
            System.out.println("Invalid count");
            return;
        }
        int realCount = 0;
        int condition = "even".equals(oddEven) ? 0 : 1;
        for (int i = 0; realCount < count && i < numbers.length; i++) {
            if (numbers[i] % 2 == condition) {
                realCount++;
            }
        }
        if (realCount < 1) {
            System.out.println("[]");
            return;
        }
        int[] currentNum = new int[realCount];
        int index = 0;
        realCount = 0;
        for (int i = 0; realCount < count && i < numbers.length; i++) {
            if (numbers[i] % 2 == condition) {
                currentNum[index++] = numbers[i];
                realCount++;
            }
        }
        System.out.println(Arrays.toString(currentNum));
    }


    private static int elementIndex(int[] numbers, String oddEven, String minMax) {
        int index = -1;
        int num = oddEven.equals("even") ? 0 : 1;
        if (minMax.equals("max")) {
            int maxElement = Integer.MIN_VALUE;

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == num && maxElement <= numbers[i]) {
                    maxElement = numbers[i];
                    index = i;
                }
            }

        } else if (minMax.equals("min")) {
            int minElement = Integer.MAX_VALUE;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == num && minElement >= numbers[i]) {
                    minElement = numbers[i];
                    index = i;
                }
            }
        }
        return index;
    }

    private static void exchange(int[] numbers, int index) {
        for (int i = 0; i <= index; i++) {
            int num = numbers[0];
            for (int j = 0; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j + 1];
            }
            numbers[numbers.length - 1] = num;
        }
    }

//    private static void exchange(int[] numbers, int index) {
//        int count = 0;
//        int[] result = new int[numbers.length];
//        for (int i = index + 1; i < numbers.length; i++) {
//            result[count++] = numbers[i];
//        }
//
//        for (int i = 0; i <= index; i++) {
//            result[count++] = numbers[i];
//        }
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = result[i];
//        }
//    }
}
