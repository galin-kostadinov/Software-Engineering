using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        string[] stringArray = Console.ReadLine().Split().ToArray();

        for (int i = 0; i < stringArray.Length; i++)
        {
            Console.Write(stringArray[stringArray.Length - i - 1] + " ");
        }
    }
}