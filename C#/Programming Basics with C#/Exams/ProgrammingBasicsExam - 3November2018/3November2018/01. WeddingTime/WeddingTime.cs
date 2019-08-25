using System;

class WeddingTime
{
    static void Main()
    {
        double whiskeyPrice = double.Parse(Console.ReadLine());
        double waterQuantity = double.Parse(Console.ReadLine());
        double wineQuantity = double.Parse(Console.ReadLine());
        double champagneQuantity = double.Parse(Console.ReadLine());
        double whiskeyQuantity = double.Parse(Console.ReadLine());

        double champagnePrice = whiskeyPrice * 0.5;
        double winePrice = champagnePrice * 0.4;
        double waterPrice = champagnePrice * 0.1;

        double totalPrice = whiskeyQuantity * whiskeyPrice + waterQuantity * waterPrice + wineQuantity * winePrice + champagneQuantity * champagnePrice;
        Console.WriteLine($"{totalPrice:F2}");
    }
}