using System;

class MatchTickets
{
    static void Main()
    {
        double budget = double.Parse(Console.ReadLine());
        string category = Console.ReadLine().ToLower();
        int peopleCount = int.Parse(Console.ReadLine());
        double leftMoney = 0.0;

        if (peopleCount >= 1 && peopleCount <= 4)
        {
            budget = budget - budget * 0.75;
            if (category == "vip")
            {
                leftMoney = budget - peopleCount * 499.99;
            }
            else if (category == "normal")
            {
                leftMoney = budget - peopleCount * 249.99;
            }
        }
        else if (peopleCount >= 5 && peopleCount <= 9)
        {
            budget = budget - budget * 0.60;
            if (category == "vip")
            {
                leftMoney = budget - peopleCount * 499.99;
            }
            else if (category == "normal")
            {
                leftMoney = budget - peopleCount * 249.99;
            }
        }
        else if (peopleCount >= 10 && peopleCount <= 24)
        {
            budget = budget - budget * 0.50;
            if (category == "vip")
            {
                leftMoney = budget - peopleCount * 499.99;
            }
            else if (category == "normal")
            {
                leftMoney = budget - peopleCount * 249.99;
            }
        }
        else if (peopleCount >= 25 && peopleCount <= 49)
        {
            budget = budget - budget * 0.40;
            if (category == "vip")
            {
                leftMoney = budget - peopleCount * 499.99;
            }
            else if (category == "normal")
            {
                leftMoney = budget - peopleCount * 249.99;
            }
        }
        else if (peopleCount >= 50)
        {
            budget = budget - budget * 0.25;
            if (category == "vip")
            {
                leftMoney = budget - peopleCount * 499.99;
            }
            else if (category == "normal")
            {
                leftMoney = budget - peopleCount * 249.99;
            }
        }

        if (leftMoney >= 0)
        {
            Console.WriteLine($"Yes! You have {leftMoney:F2} leva left.");
        }
        else if (leftMoney < 0)
        {
            Console.WriteLine($"Not enough money! You need {Math.Abs(leftMoney):F2} leva.");
        }
    }
}
