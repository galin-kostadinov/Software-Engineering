using System;

class Graduation
{
    static void Main()
    {
        string name = Console.ReadLine();
        int counter = 1;
        double sum = 0.0;

        while (counter <= 12)
        {
            double evaluation = double.Parse(Console.ReadLine());
            if (evaluation >= 4 && evaluation <= 6)
            {
                sum = sum + evaluation;
                ++counter;
            }

        }

        double average = sum / 12;

        Console.WriteLine($"{name} graduated. Average grade: {average:F2}");
    }
}
