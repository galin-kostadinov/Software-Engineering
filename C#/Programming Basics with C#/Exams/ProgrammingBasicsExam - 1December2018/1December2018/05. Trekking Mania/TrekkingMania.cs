using System;

class TrekkingMania
{
    static void Main()
    {
        int groupsNum = int.Parse(Console.ReadLine());
        int totalPeopleNum = 0;

        int Musala = 0;
        int MontBlanc = 0;
        int Kilimanjaro = 0;
        int K2 = 0;
        int Everest = 0;

        for (int i = 0; i < groupsNum; i++)
        {
            int peopleNum = int.Parse(Console.ReadLine());

            if (peopleNum <= 5)
            {
                Musala += peopleNum;
            }
            else if (peopleNum <= 12)
            {
                MontBlanc += peopleNum;
            }
            else if (peopleNum <= 25)
            {
                Kilimanjaro += peopleNum;
            }
            else if (peopleNum <= 40)
            {
                K2 += peopleNum;
            }
            else if (peopleNum > 40)
            {
                Everest += peopleNum;
            }
        }

        totalPeopleNum = Musala + MontBlanc + Kilimanjaro + K2 + Everest;

        Console.WriteLine($"{(100.0 * Musala / totalPeopleNum):F2}%");
        Console.WriteLine($"{(100.0 * MontBlanc / totalPeopleNum):F2}%");
        Console.WriteLine($"{(100.0 * Kilimanjaro / totalPeopleNum):F2}%");
        Console.WriteLine($"{(100.0 * K2 / totalPeopleNum):F2}%");
        Console.WriteLine($"{(100.0 * Everest / totalPeopleNum):F2}%");

    }
}