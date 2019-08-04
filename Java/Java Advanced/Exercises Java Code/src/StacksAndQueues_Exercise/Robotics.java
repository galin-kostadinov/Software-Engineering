package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(";");

        String[] robotsNames = new String[input.length];
        int[] productivity = new int[input.length];
        int[] workTime = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            String[] data = input[i].split("-");
            robotsNames[i] = data[0];
            productivity[i] = Integer.parseInt(data[1]);
        }

        String startTime = sc.nextLine();

        ArrayDeque<String> products = new ArrayDeque<>();

        String inputProducts = "";

        while (!"End".equals(inputProducts = sc.nextLine())) {
            products.offer(inputProducts);
        }

        String[] timeData = startTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minute = Integer.parseInt(timeData[1]);
        int second = Integer.parseInt(timeData[2]);

        int beginSecond = hours * 3600 + minute * 60 + second;

        while (!products.isEmpty()) {
            beginSecond++;

            String product = products.poll();

            boolean isAssigned = false;

            for (int i = 0; i < robotsNames.length; i++) {
                if (workTime[i] == 0 && !isAssigned) {
                    workTime[i] = productivity[i];
                    isAssigned = true;
                    printRobotData(robotsNames[i], product, beginSecond);
                }

                if (workTime[i] > 0) {
                    workTime[i]--;
                }
            }

            if (!isAssigned) {
                products.offer(product);
            }
        }
    }

    private static void printRobotData(String robotsName, String product, int beginSecond) {
        long s = beginSecond % 60;
        long m = (beginSecond / 60) % 60;
        long h = (beginSecond / (60 * 60)) % 24;
        System.out.println(robotsName + " - " + product +
                String.format(" [%02d:%02d:%02d]", h, m, s));
    }
}
