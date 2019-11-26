using System;
using System.Text;

namespace ReplRepeatChars
{
    class Program
    {
        static void Main()
        {
            string input = Console.ReadLine();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < input.Length - 1; i++)
            {
                if (input[i] != input[i + 1])
                {
                    sb.Append(input[i]);
                }
                if (i == input.Length - 2)
                {
                    sb.Append(input[i + 1]);
                }
            }

            Console.WriteLine(sb);
        }
    }
}
