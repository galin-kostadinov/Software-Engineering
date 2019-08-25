using System;

class HotelRoom
{
    static void Main()
    {
        string mount = Console.ReadLine().ToLower();
        int numberOfNights = int.Parse(Console.ReadLine());
        double studioPrice = 0.0;
        double appartmentPrice = 0.0;
        if (mount == "may" || mount == "october")
        {
            studioPrice = numberOfNights * 50.0;
            appartmentPrice = numberOfNights * 65.0;
            if (numberOfNights > 7 && numberOfNights <= 14)
            {
                studioPrice = studioPrice - studioPrice * 0.05;
            }
            else if (numberOfNights > 14)
            {
                studioPrice = studioPrice - studioPrice * 0.30;
            }
        }
        else if (mount == "june" || mount == "september")
        {
            studioPrice = numberOfNights * 75.20;
            appartmentPrice = numberOfNights * 68.70;
            if (numberOfNights > 14)
            {
                studioPrice = studioPrice - studioPrice * 0.20;
            }
        }
        else if (mount == "july" || mount == "august")
        {
            studioPrice = numberOfNights * 76.0;
            appartmentPrice = numberOfNights * 77.0;
        }

        if (numberOfNights > 14)
        {
            appartmentPrice = appartmentPrice * 0.9;
        }
        Console.WriteLine($"Apartment: {appartmentPrice:F2} lv.");
        Console.WriteLine($"Studio: {studioPrice:F2} lv.");
    }
}