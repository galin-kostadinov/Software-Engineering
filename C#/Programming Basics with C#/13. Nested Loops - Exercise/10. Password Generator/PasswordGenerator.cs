using System;
using System.Collections.Generic;

class PasswordGenerator
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        int l = int.Parse(Console.ReadLine());

        List<char> letters = new List<char>();

        for (char z = 'a'; z <= 'z'; z++)
        {
            letters.Add(z);
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                for (char k = 'a'; k < letters[l]; k++)
                {
                    for (char m = 'a'; m < letters[l]; m++)
                    {
                        for (int o = Math.Max(i, j) + 1; o <= n; o++)
                        {
                            Console.Write($"{i}{j}{k}{m}{o} ");
                        }
                    }
                }
            }
        }

        Console.WriteLine();
    }
}
