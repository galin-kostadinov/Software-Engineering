using System;

class Choreography
{
    static void Main()
    {
        int NumberOfSteps = int.Parse(Console.ReadLine());
        int NumberOfDancers = int.Parse(Console.ReadLine());
        int NumberOfDaysForLearning = int.Parse(Console.ReadLine());

        double percentStepPerDey = Math.Ceiling(((1.0 * NumberOfSteps / NumberOfDaysForLearning) / NumberOfSteps * 1.0) * 100);
        double StepsPerDancer = percentStepPerDey / NumberOfDancers;

        if (percentStepPerDey <= 13)
        {
            Console.WriteLine($"Yes, they will succeed in that goal! {StepsPerDancer:F2}%.");
        }
        else
        {
            Console.WriteLine($"No, they will not succeed in that goal! Required {StepsPerDancer:F2}% steps to be learned per day.");
        }
    }
}
