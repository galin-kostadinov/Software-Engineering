using System;
using System.Text.RegularExpressions;

namespace MatchFullName
{
    class Program
    {
        static void Main()
        {
            string pattern = @"\b([A-Z][a-z]+) ([A-Z][a-z]+)\b";
            string input = Console.ReadLine();
            RegexOptions options = RegexOptions.Multiline;

            foreach (Match m in Regex.Matches(input, pattern, options))
            {
                Console.Write(m.Value + " ");
            }
        }
    }
}
