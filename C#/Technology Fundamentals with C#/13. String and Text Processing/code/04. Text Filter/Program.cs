using System;

namespace TextFilter
{
    class Program
    {
        static void Main()
        {
            string[] bannedWords = Console.ReadLine().Split(", ");
            string text = Console.ReadLine();

            for (int i = 0; i < bannedWords.Length; i++)
            {
                string asterisks = new string('*', bannedWords[i].Length);
                text = text.Replace(bannedWords[i], asterisks);
            }

            Console.WriteLine(text);
        }
    }
}
