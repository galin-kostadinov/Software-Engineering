using System;
using System.Text;

class Coding
{
    static void Main()
    {
        string nToString = Console.ReadLine();
        int n = int.Parse(nToString);
        int length = nToString.Length;
        //string nToString = n.ToString();


        for (int row = length - 1; row >= 0; row--)
        {
            int number = n % 10;
            n = (n - number) / 10;

            if (number != '0')// Тук условието е грешно
            {
                int sum = 33 + number;
                char symbol = Convert.ToChar(sum);
                for (int i = 0; i < number; i++)
                {
                    Console.Write(symbol);
                }
                Console.WriteLine();
            }
            else
            {
                Console.WriteLine("ZERO");
            }
        }
    }
}
