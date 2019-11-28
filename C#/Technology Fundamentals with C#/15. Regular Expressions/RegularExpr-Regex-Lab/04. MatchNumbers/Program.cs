using System;
using System.Text.RegularExpressions;

public class Example
{
    public static void Main()
    {
        string pattern = @"(^|(?<=\s))-?\d+(\.\d+)?($|(?=\s))";
        string input = Console.ReadLine();
        RegexOptions options = RegexOptions.Multiline;

        foreach (Match m in Regex.Matches(input, pattern, options))
        {
            Console.Write(m.Value + " ");
        }
        Console.WriteLine();
    }
}
