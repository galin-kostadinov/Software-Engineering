﻿using System;

class Substitute
{
    static void Main()
    {
        int K = int.Parse(Console.ReadLine());
        int L = int.Parse(Console.ReadLine());
        int M = int.Parse(Console.ReadLine());
        int N = int.Parse(Console.ReadLine());
        int counter = 0; //== 6

        for (int i = K; i <= 8; i++)
        {
            for (int j = 9; j >= L; j--)
            {
                for (int k = M; k <= 8; k++)
                {
                    for (int l = 9; l >= N; l--)
                    {
                        if (i % 2 == 0 && j % 2 == 1 && k % 2 == 0 && l % 2 == 1)
                        {
                            if (i != k || j != l)
                            {
                                Console.WriteLine($"{i}{j} - {k}{l}");
                                counter++;
                                if (counter == 6)
                                {
                                    return;
                                }
                            }
                            else
                            {
                                Console.WriteLine("Cannot change the same player.");
                            }
                        }
                    }
                }
            }
        }
    }
}