using System;

class MathPuzzle
{
    static void Main()
    {
        int key = int.Parse(Console.ReadLine());
        int counter = 0;

        for (int a = 1; a <= 30; a++)
        {
            for (int b = 1; b <= 30; b++)
            {
                for (int c = 1; c <= 30; c++)
                {
                    if (a < b && b < c)
                    {
                        int sum = a + b + c;
                        if (sum == key)
                        {
                            Console.WriteLine($"{a} + {b} + {c} = {key}");
                            counter++;
                        }
                    }

                    if (a > b && b > c)
                    {
                        int product = a * b * c;
                        if (product == key)
                        {
                            Console.WriteLine($"{a} * {b} * {c} = {key}");
                            counter++;
                        }
                    }
                }
            }
        }

        if (counter == 0)
        {
            Console.WriteLine("No!");
        }
    }
}