using System;
using System.Text;

namespace DigitsLettersAndOther
{
    class Program
    {
        static void Main()
        {
            string text = Console.ReadLine();
            StringBuilder digit = new StringBuilder();
            StringBuilder letters = new StringBuilder();
            StringBuilder otherChars = new StringBuilder();

            for (int i = 0; i < text.Length; i++)
            {
                if (char.IsLetter(text[i]))
                {
                    letters.Append(text[i]);
                }
                else if (char.IsDigit(text[i]))
                {
                    digit.Append(text[i]);
                }
                else
                {
                    otherChars.Append(text[i]);
                }
            }

            Console.WriteLine(digit);
            Console.WriteLine(letters);
            Console.WriteLine(otherChars);
        }
    }
}
