using System;

class toyShop
{
    static void Main()
    {
        double excursionPrice = double.Parse(Console.ReadLine());
        int puzzel = int.Parse(Console.ReadLine());
        int talkDoll = int.Parse(Console.ReadLine());
        int teddyBear = int.Parse(Console.ReadLine());
        int minion = int.Parse(Console.ReadLine());
        int truck = int.Parse(Console.ReadLine());

        double sum = puzzel * 2.6 + talkDoll * 3.0 + teddyBear * 4.1 + minion * 8.2 + truck * 2;
        int numberOftoys = puzzel + talkDoll + teddyBear + minion + truck;

        if (numberOftoys >= 50)
        {
            sum = sum * 0.75;
        }
        double profit = sum * 0.9;


        double leftMoney = profit - excursionPrice;
        if (leftMoney >= 0)
        {
            Console.WriteLine($"Yes! {leftMoney:F2} lv left.");
        }
        else
        {
            Console.WriteLine($"Not enough money! {Math.Abs(leftMoney):F2} lv needed.");
        }
    }
}
