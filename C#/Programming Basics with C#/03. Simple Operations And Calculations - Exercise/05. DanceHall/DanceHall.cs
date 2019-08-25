using System;

class DanceHall
{
    static void Main()
    {
        double hallLenght = double.Parse(Console.ReadLine());
        double hallWidth = double.Parse(Console.ReadLine());
        double wardrobeSide = double.Parse(Console.ReadLine());

        double hallArea = hallLenght * hallWidth * 100 * 100;
        double wardrobeArea = wardrobeSide * wardrobeSide * 100 * 100;
        double benchArea = hallArea / 10;

        double freeSpace = hallArea - wardrobeArea - benchArea;
        double dancersCount = Math.Floor(freeSpace / (7000 + 40));
        Console.WriteLine(dancersCount);

    }
}
