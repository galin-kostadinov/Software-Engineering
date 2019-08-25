using System;

class Numbers
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());

        int row = n / 100 + (n % 100 - n % 10) / 10;
        int col = n / 100 + n % 10;

        int firstIndex = n / 100;
        int secondIndex = (n % 100 - n % 10) / 10;
        int lastIndex = n % 10;

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (n % 5 == 0)
                {
                    n = n - firstIndex;
                }
                else if (n % 3 == 0)
                {
                    n = n - secondIndex;
                }
                else
                {
                    n = n + lastIndex;
                }
                Console.Write($"{n} ");
            }

            Console.WriteLine();
        }
    }
}

