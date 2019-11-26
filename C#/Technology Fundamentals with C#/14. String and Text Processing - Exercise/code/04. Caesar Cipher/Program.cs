using System;
using System.Text;

namespace Caesar_Cipher
{
    class Program
    {
        static void Main()
        {
            string text = Console.ReadLine();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < text.Length; i++)
            {
                char replaceChar = (char)(text[i] + 3);
                sb.Append(replaceChar);
            }

            Console.WriteLine(sb);
        }

    }
}
