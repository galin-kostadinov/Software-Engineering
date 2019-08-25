using System;

class SkiTrip
{
    static void Main()
    {
        int days = int.Parse(Console.ReadLine());
        days -= 1;
        string typeRoom = Console.ReadLine();
        string rating = Console.ReadLine();
        double hotelCost = 0;

        switch (typeRoom)
        {
            case "room for one person":
                hotelCost = days * 18.0;
                break;
            case "apartment":
                hotelCost = days * 25.0;
                if (days < 10)
                {
                    hotelCost *= 0.7;
                }
                else if (days <= 15)
                {
                    hotelCost *= 0.65;
                }
                else if (days > 15)
                {
                    hotelCost *= 0.5;
                }
                break;
            case "president apartment":
                hotelCost = days * 35.0;
                if (days < 10)
                {
                    hotelCost *= 0.9;
                }
                else if (days <= 15)
                {
                    hotelCost *= 0.85;
                }
                else if (days > 15)
                {
                    hotelCost *= 0.8;
                }
                break;

            default:
                break;
        }

        if (rating == "positive")
        {
            hotelCost *= 1.25;
        }
        else
        {
            hotelCost *= 0.9;
        }

        Console.WriteLine($"{hotelCost:F2}");
    }
}