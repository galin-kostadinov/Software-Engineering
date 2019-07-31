using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        string[] days =
        {
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
        };

        int dayNum = int.Parse(Console.ReadLine());
        if (dayNum > 7 || dayNum < 1)
        {
            Console.WriteLine("Invalid day!");
        }
        else
        {
            Console.WriteLine(days[dayNum - 1]);
        }
    }
}