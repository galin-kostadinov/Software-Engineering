using System;
using System.Linq;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        List<string> lessons = Console.ReadLine().Split(", ").ToList();

        while (true)
        {
            List<string> course = Console.ReadLine().Split(":").ToList();
            string command = course[0];

            if (command == "course start")
            {
                break;
            }

            string courseType = course[1];

            if (command == "Add")
            {
                if (!lessons.Contains(courseType))
                {
                    lessons.Add(courseType);
                }
            }
            else if (command == "Insert")
            {
                if (!lessons.Contains(courseType))
                {
                    int courseTypeIndex = int.Parse(course[2]);
                    lessons.Insert(courseTypeIndex, courseType);
                }
            }
            else if (command == "Remove")
            {
                string exercise = courseType + "-Exercise";
                lessons.Remove(courseType);
                lessons.Remove(exercise);

            }
            else if (command == "Swap")
            {
                string firstLessonType = course[1];
                string secondLessonType = course[2];
                int firstLessonIndex = lessons.IndexOf(firstLessonType);
                int secondLessonIndexs = lessons.IndexOf(secondLessonType);

                string firstLessonExercise = firstLessonType + "-Exercise";
                string secondLessonExercise = secondLessonType + "-Exercise";
                int firstExerciseIndex = lessons.IndexOf(firstLessonExercise);
                int secondExerciseIndexs = lessons.IndexOf(secondLessonExercise);

                if (lessons.Contains(firstLessonType) && lessons.Contains(secondLessonType))
                {
                    lessons[firstLessonIndex] = secondLessonType;
                    lessons[secondLessonIndexs] = firstLessonType;
                }
                if (lessons.Contains(firstLessonExercise) && lessons.Contains(secondLessonExercise))
                {
                    lessons[firstExerciseIndex] = secondLessonExercise;
                    lessons[secondExerciseIndexs] = firstLessonExercise;
                }
                else
                {
                    if (lessons.Contains(firstLessonExercise))
                    {
                        lessons.Remove(firstLessonExercise);
                        lessons.Insert(secondLessonIndexs + 1, firstLessonExercise);
                    }
                    if (lessons.Contains(secondLessonExercise))
                    {
                        lessons.Remove(secondLessonExercise);
                        lessons.Insert(firstLessonIndex + 1, secondLessonExercise);
                    }
                }
            }
            else if (command == "Exercise")
            {
                if (lessons.Contains(courseType))
                {
                    string exercise = courseType + "-Exercise";
                    if (!lessons.Contains(exercise))
                    {
                        int courseTypeIndex = lessons.IndexOf(courseType);

                        lessons.Insert(courseTypeIndex + 1, exercise);
                    }
                }
                else
                {
                    string exercise = courseType + "-Exercise";
                    lessons.Add(courseType);
                    lessons.Add(exercise);
                }
            }
        }
        for (int i = 1; i <= lessons.Count; i++)
        {
            Console.WriteLine($"{i}.{lessons[i - 1]}");
        }
    }
}