using System;

class Grades
{
    public static void Main()
    {
        double gradeInput = double.Parse(Console.ReadLine());
        gradeInText(gradeInput);

    }
    public static void gradeInText(double grade)
    {
        if (grade >= 2 && grade <= 2.99)
        {
            Console.WriteLine("Fail");
        }
        else if (grade <= 3.49)
        {
            Console.WriteLine("Poor");
        }
        else if (grade <= 4.49)
        {
            Console.WriteLine("Good");
        }
        else if (grade <= 5.49)
        {
            Console.WriteLine("Very good");
        }
        else if (grade <= 6.00)
        {
            Console.WriteLine("Excellent");
        }
    }
}