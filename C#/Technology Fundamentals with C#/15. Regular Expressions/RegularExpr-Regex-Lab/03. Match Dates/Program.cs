using System;
using System.Text.RegularExpressions;

public class Example
{
    public static void Main()
    {
        string pattern = @"\b(\d{2})([-.\/])([A-Z][a-z]{2})\2(\d{4})\b";
        string input = Console.ReadLine();
        RegexOptions options = RegexOptions.Multiline;

        foreach (Match m in Regex.Matches(input, pattern, options))
        {
            string[] date = m.Value.Split(new char[] { '.', '/', '-' });

            Console.WriteLine($"Day: {date[0]}, Month: {date[1]}, Year: {date[2]}");
        }
    }
}
