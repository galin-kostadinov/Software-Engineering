using System;

class ProjectPrize
{
    static void Main()
    {
        int projectPartsNum = int.Parse(Console.ReadLine());
        double profitByPoint = double.Parse(Console.ReadLine());
        double totalProfit = 0;

        for (int i = 1; i <= projectPartsNum; i++)
        {
            int pointsByPart = int.Parse(Console.ReadLine());
            if (i % 2 == 0)
            {
                pointsByPart *= 2;
            }
            totalProfit += pointsByPart * profitByPoint;
        }

        Console.WriteLine($"The project prize was {totalProfit:F2} lv.");

    }
}