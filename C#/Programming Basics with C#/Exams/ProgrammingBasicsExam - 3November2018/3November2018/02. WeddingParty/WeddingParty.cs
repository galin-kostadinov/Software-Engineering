using System;

class WeddingParty
{
    static void Main()
    {

        int guests = int.Parse(Console.ReadLine());
        int budget = int.Parse(Console.ReadLine());

        int price = guests * 20;
        int leftMoney = budget - price;

        if (leftMoney >= 0)
        {
            int donation = 60 * leftMoney / 100;
            int fireworks = leftMoney - donation;
            Console.WriteLine($"Yes! {fireworks} lv are for fireworks and {donation} lv are for donation.");
        }
        else
        {
            Console.WriteLine($"They won't have enough money to pay the covert. They will need {Math.Abs(leftMoney)} lv more.");
        }
    }
}