using System;

class SumPrimeNonPrimeII
{
    static void Main()
    {
        int primeNumbersSum = 0;
        int notPrimeNumbersSum = 0;
        string input = Console.ReadLine();

        while (input != "stop")
        {
            int num = int.Parse(input);

            if (num < 0)
            {
                Console.WriteLine("Number is negative.");
            }
            else if (num > 0)
            {
                bool primeNum = true;

                for (int n = 2; n <= num / 2; n++)
                {
                    if (num % n == 0)
                    {
                        notPrimeNumbersSum = notPrimeNumbersSum + num;
                        primeNum = false;
                        break;
                    }
                }

                if (primeNum)
                {
                    primeNumbersSum = primeNumbersSum + num;
                }
            }
            else
            {
                primeNumbersSum = primeNumbersSum + num;
            }
            input = Console.ReadLine();
        }

        Console.WriteLine($"Sum of all prime numbers is: {primeNumbersSum}");
        Console.WriteLine($"Sum of all non prime numbers is: {notPrimeNumbersSum}");
    }
}
