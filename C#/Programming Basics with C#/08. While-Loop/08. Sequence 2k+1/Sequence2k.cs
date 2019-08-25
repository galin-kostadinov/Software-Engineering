using System;

class Sequence2k
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        int numbers = 0;
        while (numbers < n)
        {
            numbers = numbers * 2 + 1;
            if (numbers <= n)
            {
                Console.WriteLine(numbers);
            }
        }
    }
}
