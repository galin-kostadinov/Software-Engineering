using System;

namespace _02._Repeat_Strings
{
    class Program
    {
        static void Main()
        {
            string[] words = Console.ReadLine().Split();

            string result = "";

            foreach (var word in words)
            {
                int repeatTimes = word.Length;

                for (int i = 0; i < repeatTimes; i++)
                {
                    result += word;
                }

            }

            Console.WriteLine(result);
        }
    }
}
