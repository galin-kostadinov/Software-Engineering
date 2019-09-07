using System;

public class PalindromeIntegers
{
    public static void Main()
    {
        while (true)
        {
            string word = Console.ReadLine();
            if (word == "END")
            {
                break;
            }
            string reversedWord = ReversedWord(word);

            bool isPalindrom = IsPalindrom(word, reversedWord);
            Console.WriteLine(isPalindrom ? "true" : "false");
        }
    }

    private static string ReversedWord(string word)
    {
        string reversedWord = string.Empty;
        for (int i = word.Length - 1; i >= 0; i--)
        {
            reversedWord += word[i];
        }
        return reversedWord;
    }

    private static bool IsPalindrom(string word, string reversedWord)
    {
        return word == reversedWord ? true : false;
    }
}
