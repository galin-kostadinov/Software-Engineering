using System;

class WeddingSeats
{
    static void Main()
    {
        char lastSector = char.Parse(Console.ReadLine());
        int numOfRowInFirstSector = int.Parse(Console.ReadLine());
        int OddSeatNum = int.Parse(Console.ReadLine());
        int ЕvenSeatNum = OddSeatNum + 2;
        int totalSeatNum = 0;
        int counter = 1;
        char oddChar = ' ';
        char EvenChar = ' ';

        for (char i = 'a'; i <= 'z'; i++)
        {
            if (counter == OddSeatNum)
            {
                oddChar = i;
            }

            if (counter == ЕvenSeatNum)
            {
                EvenChar = i;
            }
            counter++;
        }

        for (char i = 'A'; i <= lastSector; i++)
        {
            for (int j = 1; j <= numOfRowInFirstSector; j++)
            {
                for (char k = 'a'; k <= EvenChar; k++)
                {
                    if (j % 2 == 1)
                    {
                        if (k <= oddChar)
                        {
                            Console.WriteLine($"{i}{j}{k}");
                            totalSeatNum++;
                        }
                    }
                    else if (j % 2 == 0)
                    {
                        Console.WriteLine($"{i}{j}{k}");
                        totalSeatNum++;
                    }
                }
            }

            numOfRowInFirstSector++;
        }
        Console.WriteLine(totalSeatNum);
    }
}