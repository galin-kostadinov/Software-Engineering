using System;

class NumberInRange
{
    static void Main()
    {
        //Console.Write("Enter a number in the range [1...100]: ");
        //int num = int.Parse(Console.ReadLine());

        //while (num < 1 || num > 100)
        //{
        //    Console.WriteLine("Invalid number!");
        //    Console.Write("Enter a number in the range [1...100]: ");
        //    num = int.Parse(Console.ReadLine());
        //}
        //Console.WriteLine($"The number is: {num}");

        //Console.Write("Enter a number in the range [1...100]: ");

        int num = int.Parse(Console.ReadLine());

        while (num < 1 || num > 100)
        {
            // Console.WriteLine("Invalid number!");
            //Console.Write("Enter a number in the range [1...100]: ");
            num = int.Parse(Console.ReadLine());
        }
        Console.WriteLine(num);
    }
}
