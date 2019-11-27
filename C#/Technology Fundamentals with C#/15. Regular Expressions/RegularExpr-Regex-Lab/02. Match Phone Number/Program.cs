using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

public class Example
{
    public static void Main()
    {
        string pattern = @"\+(359)([ -]+)(2)\2[0-9]{3}\2[0-9]{4}\b";
        string input = Console.ReadLine();
        RegexOptions options = RegexOptions.Multiline;
        List<string> matchedDates = new List<string>();

        foreach (Match m in Regex.Matches(input, pattern, options))
        {
            matchedDates.Add(m.Value);
        }
        Console.WriteLine(string.Join(", ", matchedDates));
    }
}
