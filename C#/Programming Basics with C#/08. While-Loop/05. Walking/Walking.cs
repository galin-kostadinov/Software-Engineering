using System;

class Walking
{
    static void Main()
    {
        var a = "a";
        int sum = 0;
        while (a != "Going home" && sum < 10000)
        {
            a = Console.ReadLine();

            if (a == "Going home")
            {
                sum = sum + int.Parse(Console.ReadLine());
            }
            else
            {
                sum = sum + int.Parse(a);
            }
        }
        if (sum >= 10000)
        {
            Console.WriteLine("Goal reached! Good job!");
        }
        else
        {
            Console.WriteLine($"{10000 - sum} more steps to reach goal.");
        }
    }
}
