using System;
using System.Linq;

namespace _05._Odd_Times
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int result = 0;
            for (int i = 0; i < numbers.Length; i++)
            {
                result = result ^ numbers[i]; // 011 011 ->000 ; 011 011 011 ->011
            }
            Console.WriteLine(result);
        }
    }
}
