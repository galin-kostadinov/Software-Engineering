using System;

class SafePasswordsGenerator
{
    static void Main()
    {
        int a = int.Parse(Console.ReadLine());
        int b = int.Parse(Console.ReadLine());
        int max = int.Parse(Console.ReadLine());
        int counter = 0;
        int A = 35;
        int B = 64;

        for (int k = 1; k <= a; k++)
        {
            for (int l = 1; l <= b; l++)
            {
                counter++;

                if (A > 55)
                {
                    A = 35;
                }

                if (B > 96)
                {
                    B = 64;
                }

                if (counter <= max)
                {
                    Console.Write($"{(char)A}{(char)B}{k}{l}{(char)B}{(char)A}|");
                }
                else
                {
                    return;
                }

                A++;
                B++;
            }
        }
    }
}