using System;

namespace _01._Reverse_Strings
{
    class Program
    {
        static void Main()
        {
            while (true)
            {
                string text = Console.ReadLine();
                if (text == "end")
                {
                    break;
                }

                string reversedText = "";
                for (int i = 0; i < text.Length; i++)
                {
                    reversedText += text[text.Length - 1 - i];
                }

                Console.WriteLine($"{text} = {reversedText}");
            }
        }
    }
}
