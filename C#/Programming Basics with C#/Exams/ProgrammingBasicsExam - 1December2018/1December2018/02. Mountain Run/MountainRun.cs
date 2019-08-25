using System;

class Program
{
    static void Main()
    {
        double record = double.Parse(Console.ReadLine());
        double distance = double.Parse(Console.ReadLine());//meter
        double time = double.Parse(Console.ReadLine());//seconds by meter

        double needTime = distance * time + Math.Floor((distance / 50)) * 30;

        double leftTime = needTime - record;

        if (leftTime < 0)
        {
            Console.WriteLine($"Yes! The new record is {needTime:F2} seconds.");
        }
        else
        {
            Console.WriteLine($"No! He was {leftTime:F2} seconds slower.");
        }


    }
}