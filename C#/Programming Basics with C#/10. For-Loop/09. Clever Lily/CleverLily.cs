using System;

class CleverLily
{
    static void Main()
    {
        int age = int.Parse(Console.ReadLine());
        double washingMachinePrice = double.Parse(Console.ReadLine());
        int toyPrice = int.Parse(Console.ReadLine());
        double saveMoney = 0.0;
        int counterOddDays = 0;
        for (int i = 1; i <= age; i++)
        {
            if (i % 2 == 0)
            {
                ++counterOddDays;
                saveMoney = saveMoney + 10 * (counterOddDays) - 1;
            }
            else
            {
                saveMoney = saveMoney + toyPrice;
            }
        }
        if (saveMoney >= washingMachinePrice)
        {
            Console.WriteLine($"Yes! {saveMoney - washingMachinePrice:F2}");
        }
        else
        {
            Console.WriteLine($"No! {washingMachinePrice - saveMoney:F2}");
        }
    }
}

