using System;

class HalfSumElement
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        int num = 0;
        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < n; i++)
        {
            num = int.Parse(Console.ReadLine());
            sum = sum + num;
            if (maxNum < num)
            {
                maxNum = num;
            }
        }
        if (maxNum == (sum - maxNum))
        {
            Console.WriteLine("Yes");
            Console.WriteLine($"Sum = {sum - maxNum}");
        }
        else
        {
            Console.WriteLine("No");
            Console.WriteLine($"Diff = {Math.Abs(sum - maxNum * 2)}");
        }
    }
}


