using System;
using System.Text;

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
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++)
        {
            result.Append(text);
        }

        string resultText = result.ToString();

        return resultText;
    }
}