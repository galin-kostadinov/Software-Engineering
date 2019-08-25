using System;

class ComputerRoom
{
    static void Main()
    {
        string month = Console.ReadLine();
        int hours = int.Parse(Console.ReadLine());
        int people = int.Parse(Console.ReadLine());
        string dayTime = Console.ReadLine();
        double price = 0;

        switch (month)
        {
            case "march":
            case "april":
            case "may":
                if (dayTime == "day")
                {
                    price = 10.50;
                }
                else if (dayTime == "night")
                {
                    price = 8.40;
                }
                break;

            case "june":
            case "july":
            case "august":
                if (dayTime == "day")
                {
                    price = 12.60;
                }
                else if (dayTime == "night")
                {
                    price = 10.20;
                }
                break;

            default:
                break;
        }

        if (people >= 4)
        {
            price *= 0.9;
        }
        if (hours >= 5)
        {
            price *= 0.5;
        }

        double totalPrice = price * hours * people;
        Console.WriteLine($"Price per person for one hour: {price:F2}");
        Console.WriteLine($"Total cost of the visit: {totalPrice:F2}");
    }
}