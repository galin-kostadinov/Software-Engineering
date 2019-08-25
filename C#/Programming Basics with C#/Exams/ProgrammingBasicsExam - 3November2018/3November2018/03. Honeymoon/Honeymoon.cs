using System;

class Honeymoon
{
    static void Main()
    {
        double budget = double.Parse(Console.ReadLine());
        string destination = Console.ReadLine();
        int nights = int.Parse(Console.ReadLine());
        double totalPrice = 0;

        switch (destination)
        {
            case "Cairo":
                totalPrice = 2 * 250 * nights + 600;
                break;
            case "Paris":
                totalPrice = 2 * 150 * nights + 350;
                break;
            case "Lima":
                totalPrice = 2 * 400 * nights + 850;
                break;
            case "New York":
                totalPrice = 2 * 300 * nights + 650;
                break;
            case "Tokyo":
                totalPrice = 2 * 350 * nights + 700;
                break;
            default:
                break;
        }

        if (nights <= 4 && nights >= 1)
        {
            if (destination == "Cairo" || destination == "New York")
            {
                totalPrice -= totalPrice * 3 / 100;
            }
        }
        else if (nights <= 9)
        {
            if (destination == "Cairo" || destination == "New York")
            {
                totalPrice -= totalPrice * 5 / 100;
            }
            else if (destination == "Paris")
            {
                totalPrice -= totalPrice * 7 / 100;
            }
        }
        else if (nights <= 24)
        {
            if (destination == "Cairo")
            {
                totalPrice -= totalPrice * 10 / 100;
            }
            else if (destination == "Paris" || destination == "New York" || destination == "Tokyo")
            {
                totalPrice -= totalPrice * 12 / 100;
            }
        }
        else if (nights <= 49)
        {
            if (destination == "Cairo" || destination == "Tokyo")
            {
                totalPrice -= totalPrice * 17 / 100;
            }
            else if (destination == "New York" || destination == "Lima")
            {
                totalPrice -= totalPrice * 19 / 100;
            }
            else if (destination == "Paris")
            {
                totalPrice -= totalPrice * 22 / 100;
            }
        }
        else if (nights >= 50)
        {
            totalPrice -= totalPrice * 30 / 100;
        }

        double leftMoney = budget - totalPrice;

        if (leftMoney >= 0)
        {
            Console.WriteLine($"Yes! You have {leftMoney:F2} leva left.");
        }
        else
        {
            Console.WriteLine($"Not enough money! You need {Math.Abs(leftMoney):F2} leva.");
        }
    }
}