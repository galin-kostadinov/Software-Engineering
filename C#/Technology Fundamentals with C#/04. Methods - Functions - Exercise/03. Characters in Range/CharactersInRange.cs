using System;

public class CharactersInRange
{
    public static void Main()
    {
        char firstChar = char.Parse(Console.ReadLine());
        char secondChar = char.Parse(Console.ReadLine());

        PrintCharacterInRange(firstChar, secondChar);
    }

    private static void PrintCharacterInRange(char firstChar, char secondChar)
    {
        if (firstChar > secondChar)
        {
            char saveFirstChar = firstChar;
            firstChar = secondChar;
            secondChar = saveFirstChar;
        }
        for (int i = firstChar + 1; i < secondChar; i++)
        {
            Console.Write((char)i + " ");
        }
        Console.WriteLine();
    }
}
