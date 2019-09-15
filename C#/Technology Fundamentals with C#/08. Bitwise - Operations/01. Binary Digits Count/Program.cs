using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        int bit = int.Parse(Console.ReadLine());
        //string asd = Convert.ToString(n, 2);
        string binaty = DecToBinary(n);

        int counter = 0;

        for (int i = 0; i < binaty.Length; i++)
        {
            int currentBit = binaty[i] - '0';
            if (bit == currentBit)
            {
                counter++;
            }
        }
        Console.WriteLine(counter);
    }

    private static string DecToBinary(int n)
    {
        List<string> binary = new List<string>();
        if (n < 0)
        {
            n = Math.Abs(n);
        }
        while (n != 0)
        {
            string res = (n % 2).ToString();
            binary.Add(res);
            n = n / 2;
        }
        binary.Reverse();
        return string.Join("", binary);
    }
}

