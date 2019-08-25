using System;
using System.Text;

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
            byte[] asciiBytes = Encoding.ASCII.GetBytes(fishName);

            for (int i = 0; i < asciiBytes.Length; i++)
            {
                sum = sum + asciiBytes[i];
            }

            if (caughtFishesTree < 3)
            {
                profit = profit - sum / fishWeight;
            }
            else if (caughtFishesTree == 3)
            {
                profit = profit + sum / fishWeight;
                caughtFishesTree = 0;
            }

            if (caughtFishes < maxCaughtFishes)
            {
                fishName = Console.ReadLine();
                if (fishName != "Stop" && caughtFishes < maxCaughtFishes)
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
