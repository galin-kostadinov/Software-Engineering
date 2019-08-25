using System;

class Program
{
    static void Main()
    {
        int distance = int.Parse(Console.ReadLine());
        int costOfGasoline = int.Parse(Console.ReadLine());//per 100km
        double gasolinePriceLt = double.Parse(Console.ReadLine());
        int profit = int.Parse(Console.ReadLine());

        double totalCost = distance * costOfGasoline * gasolinePriceLt / 100;
        double leftMoney = profit - totalCost;

        if (leftMoney >= 0)
        {
            Console.WriteLine($"You can go home. {leftMoney:F2} money left.");
        }
        else
        {
            Console.WriteLine($"Sorry, you cannot go home. Each will receive {(1.0 * profit / 5):F2} money.");
        }
    }
}