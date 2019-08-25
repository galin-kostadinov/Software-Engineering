using System;

class ChallengeTheWedding
{
    static void Main()
    {
        int mеnNum = int.Parse(Console.ReadLine());
        int womenNum = int.Parse(Console.ReadLine());
        int tables = int.Parse(Console.ReadLine());
        int counter = 0;
        for (int i = 1; i <= mеnNum; i++)
        {
            for (int j = 1; j <= womenNum; j++)
            {

                Console.Write($"({i} <-> {j}) ");
                counter++;
                if (counter == tables)
                {
                    Console.WriteLine();
                    return;
                }
            }
        }
    }
}