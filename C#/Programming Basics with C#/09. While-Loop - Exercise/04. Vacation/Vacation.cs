using System;

class Vacation
{
    static void Main()
    {
        double needMoney = double.Parse(Console.ReadLine());
        double moneyOnhand = double.Parse(Console.ReadLine());
        string choice = "different";
        double amound = 0;
        int spendCounter = 0;
        int daysCounter = 0;

        while (needMoney > moneyOnhand && spendCounter < 5)
        {
            choice = Console.ReadLine();
            amound = double.Parse(Console.ReadLine());
            if (choice == "save")
            {
                moneyOnhand = moneyOnhand + amound;
                spendCounter = 0;
            }
            else if (moneyOnhand > amound && choice == "spend")
            {
                moneyOnhand = moneyOnhand - amound;
                ++spendCounter;
            }
            else if (choice == "spend" && moneyOnhand <= amound)
            {
                moneyOnhand = 0;
                ++spendCounter;
            }
            ++daysCounter;
        }
        if (spendCounter == 5)
        {
            Console.WriteLine("You can't save the money.");
            Console.WriteLine(daysCounter);
        }
        else if (needMoney <= moneyOnhand)
        {
            Console.WriteLine($"You saved the money for {daysCounter} days.");
        }
    }
}
