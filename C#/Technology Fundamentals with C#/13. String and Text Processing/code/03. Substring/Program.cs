using System;

namespace _03._Substring
{
    class Program
    {
        static void Main()
        {
            string word = Console.ReadLine().ToLower();
            string text = Console.ReadLine();
            int wordLenght = word.Length;

            while (true)
            {
                var nextIndexOfWord = text.IndexOf(word);

                if (nextIndexOfWord == -1)
                {
                    break;
                }

                text = text.Remove(nextIndexOfWord, wordLenght);
            }

            Console.WriteLine(text);
        }
    }
}
