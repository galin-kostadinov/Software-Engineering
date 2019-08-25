using System;

class Building
{
    static void Main()
    {
        int numOfFloors = int.Parse(Console.ReadLine());
        int numOfRooms = int.Parse(Console.ReadLine());

        if (numOfFloors > 0)
        {
            int[,] totaRoomsNum = new int[numOfFloors, numOfRooms];
            char[,] totaRoomsPrefix = new char[numOfFloors, numOfRooms];

            for (int i = 0; i < totaRoomsNum.GetLength(0); i++)
            {
                for (int j = 0; j < totaRoomsNum.GetLength(1); j++)
                {
                    totaRoomsNum[i, j] = (i + 1) * 10 + j;
                }
            }

            for (int i = 0; i < totaRoomsPrefix.GetLength(0); i++)
            {
                for (int j = 0; j < totaRoomsPrefix.GetLength(1); j++)
                {
                    if (i % 2 == 0 && i < numOfFloors - 1)
                    {
                        totaRoomsPrefix[i, j] = 'A';
                    }
                    else if (!(i % 2 == 0) && i < numOfFloors - 1)
                    {
                        totaRoomsPrefix[i, j] = 'O';
                    }
                    else
                    {
                        totaRoomsPrefix[i, j] = 'L';
                    }
                }
            }

            for (int i = totaRoomsPrefix.GetLength(0) - 1; i >= 0; i--)
            {
                for (int j = 0; j < totaRoomsPrefix.GetLength(1); j++)
                {
                    Console.Write("{0}{1}{2}", totaRoomsPrefix[i, j], totaRoomsNum[i, j], j == totaRoomsPrefix.GetLength(1) - 1 ? '\n' : ' ');
                }
            }
        }

        else
        {
            int[] totaRoomsNum = new int[numOfRooms];
            char[] totaRoomsPrefix = new char[numOfRooms];

            for (int i = 0; i < totaRoomsNum.GetLength(0); i++)
            {
                totaRoomsNum[i] = i + 10;
            }

            for (int i = 0; i < totaRoomsPrefix.GetLength(0); i++)
            {
                totaRoomsPrefix[i] = 'L';
            }

            for (int i = 0; i < totaRoomsPrefix.GetLength(0); i++)
            {
                Console.Write("{0}{1}{2}", totaRoomsPrefix[i], totaRoomsNum[i], i == totaRoomsPrefix.GetLength(1) - 1 ? '\n' : ' ');
            }
        }
    }
}
