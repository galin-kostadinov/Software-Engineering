using System;

class SchoolSupplies
{
    static void Main()
    {

        int penPacks = int.Parse(Console.ReadLine());
        int markerPacks = int.Parse(Console.ReadLine());
        double cleaner = double.Parse(Console.ReadLine());
        int percentDiscount = int.Parse(Console.ReadLine());

        double totalPrice = (penPacks * 5.8 + markerPacks * 7.2 + cleaner * 1.2) * (100 - percentDiscount) / 100;
        Console.WriteLine($"{totalPrice:F3}");
    }
}