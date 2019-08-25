using System;

class FootballKit
{
    static void Main()
    {
        double TShirtPrice = double.Parse(Console.ReadLine());
        double earnBallPrice = double.Parse(Console.ReadLine());
        double shortsPrice = TShirtPrice * 0.75;
        double socksPrice = shortsPrice * 0.20;
        double buttonsPrice = (TShirtPrice + shortsPrice) * 2;
        double totalPrice = TShirtPrice + shortsPrice + socksPrice + buttonsPrice;
        totalPrice *= 0.85;

        if (totalPrice >= earnBallPrice)
        {
            Console.WriteLine($"Yes, he will earn the world-cup replica ball!");
            Console.WriteLine($"His sum is {totalPrice:F2} lv.");
        }
        else
        {
            Console.WriteLine("No, he will not earn the world-cup replica ball.");
            Console.WriteLine($"He needs {(earnBallPrice - totalPrice):F2} lv. more.");
        }

    }
}