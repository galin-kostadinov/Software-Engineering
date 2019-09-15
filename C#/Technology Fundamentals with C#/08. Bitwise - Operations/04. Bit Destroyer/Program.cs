using System;

namespace _04._Bit_Destroyer
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());
            int pos = int.Parse(Console.ReadLine());
            int mask = ~(1 << pos);
            number = number & mask;

            Console.WriteLine(number);
        }
    }
}
