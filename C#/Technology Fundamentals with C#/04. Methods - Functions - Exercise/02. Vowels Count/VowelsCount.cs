using System;

public class VowelsCount
{
    public static void Main()
    {
        string text = Console.ReadLine();

        int vowelsCount = VowelsCounter(text);
        Console.WriteLine(vowelsCount);
    }

    private static int VowelsCounter(string text)
    {
        int counter = 0;
        char[] vowels = new[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
        for (int i = 0; i < text.Length; i++)
        {
            for (int j = 0; j < vowels.Length; j++)
            {
                if (text[i] == vowels[j])
                {
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }
}
