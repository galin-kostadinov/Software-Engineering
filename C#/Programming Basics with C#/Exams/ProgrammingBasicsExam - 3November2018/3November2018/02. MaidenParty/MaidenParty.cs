using System;

class MaidenParty
{
    static void Main()
    {

        double partyPrice = double.Parse(Console.ReadLine());
        int loveMessages = int.Parse(Console.ReadLine());
        int roses = int.Parse(Console.ReadLine());
        int keyholder = int.Parse(Console.ReadLine());
        int caricature = int.Parse(Console.ReadLine());
        int luckSurprise = int.Parse(Console.ReadLine());

        int itemNum = loveMessages + roses + keyholder + caricature + luckSurprise;
        double profit = loveMessages * 0.6 + roses * 7.2 + keyholder * 3.6 + caricature * 18.20 + luckSurprise * 22;
        if (itemNum >= 25)
        {
            profit -= profit * 0.35;
        }
        profit -= profit * 0.1;

        double leftMoney = profit - partyPrice;

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