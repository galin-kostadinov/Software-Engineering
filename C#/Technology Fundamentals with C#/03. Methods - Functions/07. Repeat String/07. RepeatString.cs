using System;

public class RepeatText
{
   public static void Main()
    {
        string text = Console.ReadLine();
        int timesToRepeatText = int.Parse(Console.ReadLine());
        Console.WriteLine(RepeatString(text, timesToRepeatText));

    }

    public static string RepeatString(string text, int count)
    {
        string result = string.Empty;
        for (int i = 0; i < count; i++)
        {
            result += text;
        }
        return result;
    }
}