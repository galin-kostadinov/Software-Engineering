using System;

class AccountBalance
{
    static void Main()
    {
        int transactionNum = int.Parse(Console.ReadLine());
        int transactionCounter = 1;
        double amounPaid = 1;
        double total = 0;
        while (transactionCounter <= transactionNum && amounPaid > 0)
        {
            ++transactionCounter;

            amounPaid = double.Parse(Console.ReadLine());
            if (amounPaid > 0)
            {
                total = total + amounPaid;
                Console.WriteLine($"Increase: {amounPaid:F2}");
            }
            else
            {
                Console.WriteLine("Invalid operation!");
            }
        }
        Console.WriteLine($"Total: {total:F2}");
    }
}
