using System;
using System.Linq;

public class Train
{
    public static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        int[] train = new int[n];
        int sum = 0;

        for (int i = 0; i < train.Length; i++)
        {
            train[i] = int.Parse(Console.ReadLine());
        }

        for (int i = 0; i < train.Length; i++)
        {
            Console.Write(train[i]+" ");
            sum += train[i];
        }
        Console.WriteLine();
        Console.WriteLine(sum);
    }
}