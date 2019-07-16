package ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> scheduleLessons = Arrays.stream(sc.nextLine().split(", ")).collect(Collectors.toList());

        String input = "";
        while (!"course start".equals(input = sc.nextLine())) {
            String[] token = input.split(":");
            String command = token[0];
            String lessonTitle = token[1];
            if (command.equals("Add")) {
                if (!scheduleLessons.contains(lessonTitle)) {
                    scheduleLessons.add(lessonTitle);
                }
            } else if (command.equals("Insert")) {
                int index = Integer.parseInt(token[2]);
                if (!scheduleLessons.contains(lessonTitle)) {
                    scheduleLessons.add(index, lessonTitle);
                }
            } else if (command.equals("Remove")) {
                if (scheduleLessons.contains(lessonTitle)) {
                    scheduleLessons.remove(lessonTitle);
                    String exercise = lessonTitle + "-Exercise";
                    scheduleLessons.remove(exercise);
                }
            } else if (command.equals("Swap")) {
                String firstLessonTitle = token[1];
                String secondLessonTitle = token[2];

                if (scheduleLessons.contains(firstLessonTitle) && scheduleLessons.contains(secondLessonTitle)) {
                    int indexOfFirst = scheduleLessons.indexOf(firstLessonTitle);
                    int indexOfSecond = scheduleLessons.indexOf(secondLessonTitle);
                    scheduleLessons.set(indexOfFirst, secondLessonTitle);
                    scheduleLessons.set(indexOfSecond, firstLessonTitle);
                    if (scheduleLessons.contains(firstLessonTitle + "-Exercise")) {
                        int indexOfFirstMoved = scheduleLessons.indexOf(firstLessonTitle);
                        scheduleLessons.remove(firstLessonTitle + "-Exercise");
                        scheduleLessons.add(indexOfFirstMoved + 1, firstLessonTitle + "-Exercise");

                    }
                    if (scheduleLessons.contains(secondLessonTitle + "-Exercise")) {
                        int indexOfSecondMoved = scheduleLessons.indexOf(secondLessonTitle);
                        scheduleLessons.remove(secondLessonTitle + "-Exercise");
                        scheduleLessons.add(indexOfSecondMoved + 1, secondLessonTitle + "-Exercise");
                    }
                }
            } else if (command.equals("Exercise")) {
                if (scheduleLessons.contains(lessonTitle)) {
                    if (!scheduleLessons.contains(lessonTitle + "-Exercise")) {
                        int index = scheduleLessons.indexOf(lessonTitle);
                        scheduleLessons.add(index + 1, lessonTitle + "-Exercise");
                    }

                } else {
                    scheduleLessons.add(lessonTitle);
                    scheduleLessons.add(lessonTitle + "-Exercise");
                }
            }
        }

        for (int i = 0; i < scheduleLessons.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, scheduleLessons.get(i));
        }
    }
}
