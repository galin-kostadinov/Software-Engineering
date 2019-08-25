using System;

class FishingBoat
{
    static void Main()
    {
        int budget = int.Parse(Console.ReadLine());
        string season = Console.ReadLine().ToLower();
        int numberFishermen = int.Parse(Console.ReadLine());
        double rent = 0;

        if (season == "summer" || season == "autumn")
        {
            rent = 4200;
        }
        else if (season == "spring")
        {
            rent = 3000;
        }
        else if (season == "winter")
        {
            rent = 2600;
        }

        if (numberFishermen >= 1 && numberFishermen <= 6)
        {
            rent = rent - rent * 0.1;
        }
        else if (numberFishermen >= 7 && numberFishermen <= 11)
        {
            rent = rent - rent * 0.15;
        }
        else if (numberFishermen >= 12)
        {
            rent = rent - rent * 0.25;
        }
        if (season != "autumn" && numberFishermen % 2 == 0)
        {
            rent = rent - rent * 0.05;
        }

        double leftMoney = budget - rent;

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