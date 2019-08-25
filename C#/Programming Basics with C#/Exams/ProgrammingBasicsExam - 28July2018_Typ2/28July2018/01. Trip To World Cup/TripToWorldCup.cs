using System;

class TripToWorldCup
{
    static void Main()
    {
        double tripThiketPrice1 = double.Parse(Console.ReadLine());
        double tripThiketPrice2 = double.Parse(Console.ReadLine());
        double matchPrice = double.Parse(Console.ReadLine());
        int matchNum = int.Parse(Console.ReadLine());
        int percentDiscount = int.Parse(Console.ReadLine());

        double tripSum = 6 * (tripThiketPrice1 + tripThiketPrice2) *(100- percentDiscount) / 100;
        double totalSum = tripSum + matchNum * matchPrice * 6;

        Console.WriteLine($"Total sum: {totalSum:F2} lv.");
        Console.WriteLine($"Each friend has to pay {(totalSum/6):F2} lv.");

    }
}k
}k