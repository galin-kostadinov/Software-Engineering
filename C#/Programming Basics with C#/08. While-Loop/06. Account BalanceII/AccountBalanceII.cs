using System;

class AccountBalance
{
    static void Main()
    {
        int transactionNum = int.Parse(Console.ReadLine());
        int transactionCounter = 0;
        double balance = 0.0;
        while (transactionCounter < transactionNum)
        {
            double amounPaid = double.Parse(Console.ReadLine());
            if (amounPaid < 0)
            {
                Console.WriteLine("Invalid operation!");
                break;
            }

            balance = balance + amounPaid;
            Console.WriteLine($"Increase: {amounPaid:F2}");
            ++transactionCounter;
        }
        Console.WriteLine($"Total: {balance:F2}");
    }
}
