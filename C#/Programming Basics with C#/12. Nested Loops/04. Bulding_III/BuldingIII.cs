using System;

class Building
{
    static void Main()
    {
        int numOfFloors = int.Parse(Console.ReadLine());
        int numOfRooms = int.Parse(Console.ReadLine());
        char prefix = ' ';
        int room = 0;
        for (int i = numOfFloors - 1; i >= 0; i--)
        {
            for (int j = 0; j < numOfRooms; j++)
            {
                if (i % 2 == 0 && i < numOfFloors - 1 && numOfFloors > 1)
                {
                    prefix = 'A';
                }
                else if (!(i % 2 == 0) && i < numOfFloors - 1 && numOfFloors > 1)
                {
                    prefix = 'O';
                }
                else
                {
                    prefix = 'L';
                }
                room = (i + 1) * 10 + j;
                Console.Write("{0}{1}{2}", prefix, room, j == numOfRooms - 1 ? '\n' : ' ');
            }
        }
    }
}
