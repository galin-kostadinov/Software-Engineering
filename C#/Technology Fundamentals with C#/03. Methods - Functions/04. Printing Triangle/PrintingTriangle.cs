﻿using System;

public class PrintingTriangle
{
    public static void Main()
    {
        int number = int.Parse(Console.ReadLine());

        PrintTriangle(number);

    }

    public static void PrintTriangle(int n)
    {

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                Console.Write(j + " ");
            }
            Console.WriteLine();
        }
        for (int i = n-1; i >= 1; i--)
        {
            for (int j = 1; j <= i; j++)
            {
                Console.Write(j + " ");
            }
            Console.WriteLine();
        }
    }
}