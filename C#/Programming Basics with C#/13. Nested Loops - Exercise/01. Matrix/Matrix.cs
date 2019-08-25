using System;

class Matrix
{
    static void Main()
    {
        int a = int.Parse(Console.ReadLine());
        int b = int.Parse(Console.ReadLine());
        int c = int.Parse(Console.ReadLine());
        int d = int.Parse(Console.ReadLine());
        for (int firstRowFirstNum = a; firstRowFirstNum <= b; firstRowFirstNum++)
        {
            for (int firstRowSecondNum = a; firstRowSecondNum <= b; firstRowSecondNum++)
            {
                for (int secondtRowFirstNum = c; secondtRowFirstNum <= d; secondtRowFirstNum++)
                {
                    for (int secondtRowSecondNum = c; secondtRowSecondNum <= d; secondtRowSecondNum++)
                    {
                        if ((firstRowFirstNum + secondtRowSecondNum) == (firstRowSecondNum + secondtRowFirstNum) &&
                            firstRowFirstNum != firstRowSecondNum && secondtRowFirstNum != secondtRowSecondNum)
                        {
                            Console.WriteLine($"{firstRowFirstNum}{firstRowSecondNum}");
                            Console.WriteLine($"{secondtRowFirstNum}{secondtRowSecondNum}");
                            Console.WriteLine();
                        }
                    }
                }
            }
        }

    }
}
