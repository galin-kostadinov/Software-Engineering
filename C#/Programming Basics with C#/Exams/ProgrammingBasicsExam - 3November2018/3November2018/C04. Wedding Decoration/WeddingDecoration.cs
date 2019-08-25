using System;

class WeddingDecoration
{
    static void Main()
    {
        double budget = double.Parse(Console.ReadLine());
        double leftMoney = budget;
        int balloons = 0;
        int ribbon = 0;
        int flowers = 0;
        int candles = 0;

        while (true)
        {
            string input = Console.ReadLine();

            if (input == "stop")
            {
                Console.WriteLine($"Spend money: {(budget - leftMoney):F2}");
                Console.WriteLine($"Money left: {leftMoney:F2}");
                break;
            }

            int quantity = int.Parse(Console.ReadLine());
            double price = 0;

            if (input == "balloons")
            {
                price = quantity * 0.1;
                balloons += quantity;
            }
            else if (input == "flowers")
            {
                price = quantity * 1.5;
                flowers += quantity;
            }
            else if (input == "candles")
            {
                price = quantity * 0.5;
                candles += quantity;
            }
            else if (input == "ribbon")
            {
                price = quantity * 2;
                ribbon += quantity;
            }

            if (leftMoney > 0)
            {
                leftMoney -= price;
            }

            if (leftMoney <= 0)
            {
                Console.WriteLine("All money is spent!");
                break;
            }
        }
        Console.WriteLine($"Purchased decoration is {balloons} balloons, {ribbon} m ribbon, {flowers} flowers and {candles} candles.");
    }
}