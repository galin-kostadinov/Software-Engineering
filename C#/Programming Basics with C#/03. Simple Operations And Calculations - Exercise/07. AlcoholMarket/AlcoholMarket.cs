using System;

class AlcoholMarket
{
    static void Main()
    {
        double wishkeyPrice = double.Parse(Console.ReadLine());
        double beerQuantity = double.Parse(Console.ReadLine());
        double wineQuantity = double.Parse(Console.ReadLine());
        double rakiaQuantity = double.Parse(Console.ReadLine());
        double wishkeyQuantity = double.Parse(Console.ReadLine());

        double rakiaPrice = wishkeyPrice * 0.5;
        double winePrice = rakiaPrice - rakiaPrice * 0.4;
        double beerPrice = rakiaPrice - rakiaPrice * 0.8;

        double rakiaSum = rakiaQuantity * rakiaPrice;
        double wineSum = wineQuantity * winePrice;
        double beerSum = beerQuantity * beerPrice;
        double wishkeySum = wishkeyQuantity * wishkeyPrice;

        double totalSum = rakiaSum + wineSum + beerSum + wishkeySum;
        Console.WriteLine($"{totalSum:F2}");
    }
}
