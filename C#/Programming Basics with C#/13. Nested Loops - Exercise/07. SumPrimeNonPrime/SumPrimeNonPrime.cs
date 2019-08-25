using System;

class SumPrimeNonPrime
{
    static void Main()
    {
        int primeNumbersSum = 0;
        int notPrimeNumbersSum = 0;

        for (var i = Console.ReadLine(); i != "stop"; i = Console.ReadLine())
        {
            int num = int.Parse(i);

            if (num < 0)
            {
                Console.WriteLine("Number is negative.");
            }
            else if (num == 0 || num == 1)
            {
                notPrimeNumbersSum += num;
            }
            else
            {
                bool primeNum = true;

                for (int n = 2; n <= Math.Sqrt(num); n++)
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
        }

        Console.WriteLine($"Sum of all prime numbers is: {primeNumbersSum}");
        Console.WriteLine($"Sum of all non prime numbers is: {notPrimeNumbersSum}");
    }
}
