﻿using System;

public class MiddleCharacters
{
    public static void Main()
    {
        string text = Console.ReadLine();

        PrintMiddleChar(text);
    }

    private static void PrintMiddleChar(string text)
    {
        if (text.Length % 2 == 0)
        {
            Console.WriteLine(text[text.Length / 2 - 1] + "" + text[text.Length / 2]);
        }
        else
        {
            Console.WriteLine(text[text.Length / 2]);
        }
    }
}
