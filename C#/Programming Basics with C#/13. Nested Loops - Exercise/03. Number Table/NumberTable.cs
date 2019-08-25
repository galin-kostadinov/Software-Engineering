using System;

class NumberTable
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        int counter = 0;
        int currentNum = 0;

        for (int row = 1; row <= n; row++)
        {
            for (int col = 1; col <= n; col++)
            {
                ++currentNum;
                if (currentNum <= n)
                {
                    ++counter;
                    Console.Write(counter + " ");
                }
                else
                {
                    --counter;
                    Console.Write(counter + " ");
                }
            }

            counter = row;
            currentNum = row;

            Console.WriteLine();
        }
    }
}
