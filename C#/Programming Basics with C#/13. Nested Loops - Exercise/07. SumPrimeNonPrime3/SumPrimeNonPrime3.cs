using System;

class SumPrimeNonPrime3
{
    static void Main()
    {
        int sumPrime = 0;
        int sumNonPtime = 0;

        while (true)
        {
            string input = Console.ReadLine();

            if (input == "stop")
            {
                break;
            }

            int num = int.Parse(input);

            if (num < 0)
            {
                Console.WriteLine("Number is negative.");
            }
            else if (num == 0 || num == 1)
            {
                sumNonPtime += num;
            }

            else
            {
                bool prime = true;

                for (int i = 2; i <= Math.Sqrt(num); i++)
                {
                    if (num % i == 0)
                    {
                        prime = false;
                        break;
                    }
                }

                if (prime)
                {
                    sumPrime += num;
                }
                else
                {
                    sumNonPtime += num;
                }
            }
        }

        Console.WriteLine($"Sum of all prime numbers is: {sumPrime}");
        Console.WriteLine($"Sum of all non prime numbers is: {sumNonPtime}");
    }
}