using System;

class NumberSequence
{
    static void Main()
    {
        var a = Console.ReadLine();

        if (a == "END")
        {
            return;
        }

        int maxNum = int.Parse(a);
        int minNum = int.Parse(a);

        while (a != "END")
        {
            int num = int.Parse(a);
            if (maxNum < num)
            {
                maxNum = num;
            }
            if (minNum > num)
            {
                minNum = num;
            }
            a = Console.ReadLine();
        }
        Console.WriteLine($"Max number: {maxNum}");
        Console.WriteLine($"Min number: {minNum}");
    }
}
