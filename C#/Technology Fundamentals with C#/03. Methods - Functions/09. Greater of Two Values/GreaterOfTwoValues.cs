using System;

public class GreaterOfTwoValues
{
    public static void Main()
    {
        string valueType = Console.ReadLine();
        
        switch (valueType)
        {
            case "int":
                int firstInt = int.Parse(Console.ReadLine());
                int secondInt = int.Parse(Console.ReadLine());
                int resultInt = GetMax(firstInt, secondInt);
                Console.WriteLine(resultInt);
                break;
            case "char":
                char firstchar = char.Parse(Console.ReadLine());
                char secondchar = char.Parse(Console.ReadLine());
                char resultChar = GetMax(firstchar, secondchar);
                Console.WriteLine(resultChar);
                break;
            case "string":
                string firstString = Console.ReadLine();
                string secondString = Console.ReadLine();
                string resultstring = GetMax(firstString, secondString);
                Console.WriteLine(resultstring);
                break;
                
        }

    }

    public static int GetMax(int first, int second)
    {
        return Math.Max(first, second);
    }

    public static char GetMax(char first, char second)
    {
        return (char)Math.Max(first, second);
    }

    public static string GetMax(string first, string second)
    {
        int comparison = first.CompareTo(second);//If first > second --> comparison > 0
        if (comparison > 0)
        {
            return first;
        }
        else
        {
            return second;
        }
    }
}

    