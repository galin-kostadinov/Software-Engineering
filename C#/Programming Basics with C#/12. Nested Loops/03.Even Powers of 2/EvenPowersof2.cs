using System;

class EvenPowersof2
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        int current = 1;

        for (int i = 0; i <= n; i += 2)
        {
            Console.WriteLine(current);
            current = current * 4;
        }
    }
}
