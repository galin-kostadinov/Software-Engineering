using System;

class ProgExamPreparationram
{
    static void Main()
    {
        int unsatisfactoryЕstimates = int.Parse(Console.ReadLine());
        string nameOfTask = "name";
        int evaluation = 0;
        int counterUnsatisfactory = 0;
        string lastTaskName = nameOfTask;
        int sumEvalutions = 0;
        int numberProblems = 0;

        while (nameOfTask != "Enough" && unsatisfactoryЕstimates > counterUnsatisfactory)
        {
            lastTaskName = nameOfTask;
            nameOfTask = Console.ReadLine();
            if (nameOfTask != "Enough")
            {
                evaluation = int.Parse(Console.ReadLine());
                if (evaluation <= 4)
                {
                    ++counterUnsatisfactory;
                }
                sumEvalutions = sumEvalutions + evaluation;
                ++numberProblems;
            }
        }

        if (nameOfTask == "Enough")
        {
            Console.WriteLine($"Average score: {1.0 * sumEvalutions / numberProblems:F2}");
            Console.WriteLine($"Number of problems: {numberProblems}");
            Console.WriteLine($"Last problem: {lastTaskName}");
        }
        else
        {
            Console.WriteLine($"You need a break, {unsatisfactoryЕstimates} poor grades.");
        }
    }
}
