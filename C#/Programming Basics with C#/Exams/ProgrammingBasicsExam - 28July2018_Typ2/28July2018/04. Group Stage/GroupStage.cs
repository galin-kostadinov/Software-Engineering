using System;

class GroupStage
{
    static void Main()
    {
        string team = Console.ReadLine();
        int meetingNum = int.Parse(Console.ReadLine());
        int totalGoalsScored = 0;
        int totalReceivedGoals = 0;
        int points = 0;

        for (int i = 0; i < meetingNum; i++)
        {
            int goalsScored = int.Parse(Console.ReadLine());
            int receivedGoals = int.Parse(Console.ReadLine());
            totalGoalsScored += goalsScored;
            totalReceivedGoals += receivedGoals;
            int goalDifference = goalsScored - receivedGoals;
            if (goalDifference > 0)
            {
                points += 3;
            }
            else if (goalDifference == 0)
            {
                points += 1;
            }
        }

        int totalGoalDifference = totalGoalsScored - totalReceivedGoals;

        if (totalGoalDifference >= 0)
        {
            Console.WriteLine($"{team} has finished the group phase with {points} points.");
            Console.WriteLine($"Goal difference: {totalGoalDifference}.");
        }
        else
        {
            Console.WriteLine($"{team} has been eliminated from the group phase.");
            Console.WriteLine($"Goal difference: {totalGoalDifference}.");
        }
    }
}