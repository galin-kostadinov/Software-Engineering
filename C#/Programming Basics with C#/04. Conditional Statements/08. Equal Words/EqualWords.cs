using System;

class EqualWords
{
    static void Main()
    {
        string firstWord = Console.ReadLine();
        string secondWord = Console.ReadLine();

        firstWord = firstWord.ToLower();
        secondWord = secondWord.ToLower();

        if (firstWord == secondWord)
        {
            Console.WriteLine("yes");
        }
        else
        {
            Console.WriteLine("no");
        }
    }
}

