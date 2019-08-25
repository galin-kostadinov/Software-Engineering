using System;

class Exam
{
    static void Main()
    {
        int studentsNumb = int.Parse(Console.ReadLine());

        int gradeFail = 0;
        int gradeGood = 0;
        int gradeVeryGood = 0;
        int gradeTop = 0;
        double averageGradeSum = 0;

        for (int i = 1; i <= studentsNumb; i++)
        {
            double grade = double.Parse(Console.ReadLine());

            if (grade <= 2.99)
            {
                gradeFail++;
            }
            else if (grade <= 3.99)
            {
                gradeGood++;
            }
            else if (grade <= 4.99)
            {
                gradeVeryGood++;
            }
            else
            {
                gradeTop++;
            }
            averageGradeSum = averageGradeSum + grade;
        }

        Console.WriteLine($"Top students: {1.0 * gradeTop / studentsNumb * 100:F2}%");
        Console.WriteLine($"Between 4.00 and 4.99: {1.0 * gradeVeryGood / studentsNumb * 100:F2}%");
        Console.WriteLine($"Between 3.00 and 3.99: {1.0 * gradeGood / studentsNumb * 100:F2}%");
        Console.WriteLine($"Fail: {1.0 * gradeFail / studentsNumb * 100:F2}%");
        Console.WriteLine($"Average: {1.0 * averageGradeSum / studentsNumb:F2}");
    }
}

