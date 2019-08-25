using System;

class SeaTrip
{
    static void Main()
    {
        double mealPricePerDay = double.Parse(Console.ReadLine());
        double souvenirPricePerDay = double.Parse(Console.ReadLine());
        double hotelPricePerDay = double.Parse(Console.ReadLine());

        double gasolinCost = 1.85 * 210 * 2.0 * 7 / 100;
        double totalHotelPrice = hotelPricePerDay * (0.9 + 0.8 + 0.85);

        double totalMoney = (mealPricePerDay + souvenirPricePerDay) * 3 + totalHotelPrice + gasolinCost;

        Console.WriteLine($"Money needed: {totalMoney:F2}");
    }
}