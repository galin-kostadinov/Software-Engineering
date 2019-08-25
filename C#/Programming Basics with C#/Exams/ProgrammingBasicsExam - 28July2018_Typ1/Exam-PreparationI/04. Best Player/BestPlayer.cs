using System;

class Program
{
    static void Main()
    {
        string player = " ";
        int goal = 0;

        while (true)
        {
            string inputPlaer = Console.ReadLine();

            if (inputPlaer == "END")
            {
                break;
            }

            int inputGoal = int.Parse(Console.ReadLine());

            if (inputGoal > goal)
            {
                goal = inputGoal;
                player = inputPlaer;
                if (goal >= 10)
                {
                    break;
                }
            }
        }

        Console.WriteLine($"{player} is the best player!");

        if (goal >= 3)
        {
            Console.WriteLine($"He has scored {goal} goals and made a hat-trick !!!");
        }
        else
        {
            Console.WriteLine($"He has scored {goal} goals.");
        }
    }
}
