using System;
using System.Text;

class CodingIII
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        string nToString = n + "";
        int length = nToString.Length;

        for (int row = 0; row < length; row++)
        {
            int number = int.Parse(nToString[length - 1 - row] + "");
            if (number == 0)
            {
                Console.WriteLine("ZERO");
                continue;
            }

            char symbolToRepeat = (char)(number + 33);
            for (int i = 0; i < number; i++)
            {
                Console.Write(symbolToRepeat);
            }
            Console.WriteLine();
        }
    }
}
