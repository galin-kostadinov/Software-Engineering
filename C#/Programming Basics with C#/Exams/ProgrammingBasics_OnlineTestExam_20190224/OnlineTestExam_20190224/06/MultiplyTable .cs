using System;

class MultiplyTable
{
    static void Main()
    {
        int number = int.Parse(Console.ReadLine());
       
        int thirthDigit = number % 10;
        number /= 10;
        int secondDigit = number % 10;
        number /= 10;
        int firstDigit = number;

        if (firstDigit > 0 && thirthDigit > 0 && secondDigit > 0)
        {
            for (int i = 1; i <= thirthDigit; i++)
            {
                for (int j = 1; j <= secondDigit; j++)
                {
                    for (int k = 1; k <= firstDigit; k++)
                    {
                        int result = i * j * k;
                        Console.WriteLine($"{i} * {j} * {k} = {result};");
                    }
                }
            }
        }
    }
}
