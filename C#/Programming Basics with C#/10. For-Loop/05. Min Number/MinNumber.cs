using System;

class MinNumber
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        int num = int.Parse(Console.ReadLine());
        int maxNum = num;
        for (int i = 1; i < n; i++)
        {
            num = int.Parse(Console.ReadLine());

            if (maxNum > num)
            {
                maxNum = num;
            }
        }
        Console.WriteLine(maxNum);
    }
}