using System;

class Fishing
{
    static void Main()
    {
        int maxCaughtFishes = int.Parse(Console.ReadLine());
        string fishName = Console.ReadLine();
        double fishWeight = double.Parse(Console.ReadLine());
        int caughtFishes = 1;
        int caughtFishesTree = 1;

        double profit = 0;
        while (fishName != "Stop" && caughtFishes <= maxCaughtFishes)
        {
            double sum = 0;
           
            for (int i = 0; i < fishName.Length; i++)
            {
                sum = sum + (double)fishName[i];
            }
            if (caughtFishesTree < 3)
            {
                profit = profit - sum / fishWeight;
            }
            else
            {
                profit = profit + sum / fishWeight;
                caughtFishesTree = 0;
            }

            if (caughtFishes < maxCaughtFishes)
            {
                fishName = Console.ReadLine();
                if (fishName != "Stop")
                {
                    fishWeight = double.Parse(Console.ReadLine());
                    ++caughtFishes;
                    ++caughtFishesTree;
                }
                else
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }
        if (caughtFishes == maxCaughtFishes)
        {
            Console.WriteLine("Lyubo fulfilled the quota!");
        }
        if (profit >= 0)
        {
            Console.WriteLine($"Lyubo's profit from {caughtFishes} fishes is {profit:F2} leva.");
        }
        else
        {
            Console.WriteLine($"Lyubo lost {Math.Abs(profit):F2} leva today.");
        }
    }
}
