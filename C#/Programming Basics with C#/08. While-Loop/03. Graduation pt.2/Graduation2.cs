using System;

class Graduation2
{
    static void Main()
    {
        string name = Console.ReadLine();
        int counter = 1;
        double sum = 0.0;
        int excludedCounter = 0;
        int numClassExcluded = 0;
        while (counter <= 12 && excludedCounter <= 1)
        {
            ++numClassExcluded;
            double evaluation = double.Parse(Console.ReadLine());
            if (evaluation >= 4 && evaluation <= 6)
            {
                sum = sum + evaluation;
                ++counter;
            }
            else if (evaluation < 4)
            {
                ++excludedCounter;
            }
        }

        if (excludedCounter <= 1)
        {
            double average = sum / 12;
            Console.WriteLine($"{name} graduated. Average grade: {average:F2}");
        }
        else if (excludedCounter > 1)
        {
            Console.WriteLine($"{name} has been excluded at {numClassExcluded - 1} grade");
        }
    }
}
