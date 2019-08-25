using System;

class WalkingII
{
    static void Main()
    {

        int sum = 0;
        int stepTarget = 1000;
        while (sum < stepTarget)
        {
            string a = Console.ReadLine();

            if (a == "Going home")
            {
                sum = sum + int.Parse(Console.ReadLine());
                break;
            }
            else
            {
                sum = sum + int.Parse(a);
            }
        }
        if (sum >= stepTarget)
        {
            Console.WriteLine("Goal reached! Good job!");
        }
        else
        {
            Console.WriteLine($"{stepTarget - sum} more steps to reach goal.");
        }
    }
}
