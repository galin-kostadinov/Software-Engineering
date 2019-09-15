using System;

namespace _02._First_Bit
{
    class Program
    {
        static void Main()
        {
            int number = int.Parse(Console.ReadLine());

            int mask = 1 << 1;
            int result = number & mask;
            result = result >> 1;
            Console.WriteLine(result);
        }
    }
}
