using System;

class ChristmasMarket
{
    static void Main()
    {
        double desiredMoney = double.Parse(Console.ReadLine());
        int fantasyBooks = int.Parse(Console.ReadLine());
        int horrorBooks = int.Parse(Console.ReadLine());
        int romanticBooks = int.Parse(Console.ReadLine());

        double profit = fantasyBooks * 14.90 + horrorBooks * 9.80 + romanticBooks * 4.30;
        profit *= 0.8;

        double leftMoney = profit - desiredMoney;
        if (leftMoney >= 0)
        {
            double receive = Math.Floor(leftMoney * 0.1);
            profit -= receive;
            Console.WriteLine($"{profit:F2} leva donated.");
            Console.WriteLine($"Sellers will receive {receive} leva.");
        }
        else
        {
            Console.WriteLine($"{Math.Abs(leftMoney):F2} money needed.");
        }
    }
}