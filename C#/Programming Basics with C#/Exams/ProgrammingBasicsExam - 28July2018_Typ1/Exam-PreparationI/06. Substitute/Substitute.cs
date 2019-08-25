using System;

class Substitute
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        int counter = 0;
        int sum = 0;

        for (char i = 'B'; i <= 'L'; i++)
        {
            for (char j = 'f'; j >= 'a'; j--)
            {
                for (char k = 'A'; k <= 'C'; k++)
                {
                    for (int l = 1; l <= 10; l++)
                    {
                        for (int m = 10; m >= 1; m--)
                        {
                            if (i % 2 == 0)
                            {
                                ++counter;
                                if (counter == n)
                                {
                                    Console.WriteLine($"Ticket combination: {i}{j}{k}{l}{m}");
                                    sum = (int)i + (int)j + (int)k + l + m;
                                    Console.WriteLine($"Prize: {sum} lv.");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
