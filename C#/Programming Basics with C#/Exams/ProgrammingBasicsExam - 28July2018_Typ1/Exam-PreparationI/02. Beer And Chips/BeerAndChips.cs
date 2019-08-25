using System;

class Program
{
    static void Main()
    {
        string name = Console.ReadLine();
        double buget = double.Parse(Console.ReadLine());
        int bottleBeer = int.Parse(Console.ReadLine());
        int numChips = int.Parse(Console.ReadLine());

        double totatBeerPrice = bottleBeer * 1.2;
        double totatChipsPrice = Math.Ceiling((totatBeerPrice * 0.45) * numChips);
        double needMoney = totatBeerPrice + totatChipsPrice;
        double leftMoney = buget - needMoney;
        if (leftMoney >= 0)
        {
            Console.WriteLine($"{name} bought a snack and has {leftMoney:F2} leva left.");
        }
        else
        {
            Console.WriteLine($"{name} needs {Math.Abs(leftMoney):F2} more leva!");
        }
    }
}
