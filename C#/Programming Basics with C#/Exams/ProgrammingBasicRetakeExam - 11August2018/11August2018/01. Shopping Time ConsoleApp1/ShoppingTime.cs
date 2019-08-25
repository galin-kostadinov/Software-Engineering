using System;

class ShoppingTime
{
    static void Main()
    {
        int lunchBreak = int.Parse(Console.ReadLine());
        double hardwarePrice = double.Parse(Console.ReadLine());
        double softwarePrice = double.Parse(Console.ReadLine());
        double whiteFrappePrice = double.Parse(Console.ReadLine());

        double totalCost = whiteFrappePrice + 3 * hardwarePrice + 2 * softwarePrice;
        int totalTimeCost = 5 + 3 * 2 + 2 * 2;
        int leftTime = lunchBreak - totalTimeCost;

        Console.WriteLine($"{totalCost:F2}");
        Console.WriteLine(leftTime);
    }
}