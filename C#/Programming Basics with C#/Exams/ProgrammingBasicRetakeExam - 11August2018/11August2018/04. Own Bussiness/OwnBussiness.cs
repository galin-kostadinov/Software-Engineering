using System;

class OwnBussiness
{
    static void Main()
    {

        int freeSpaceWidth = int.Parse(Console.ReadLine());
        int freeSpacеLenght = int.Parse(Console.ReadLine());
        int freeSpacеHight = int.Parse(Console.ReadLine());
        int freeSpase = freeSpaceWidth * freeSpacеLenght * freeSpacеHight;
        int PCVolume = 0;
        var variable = "variable";
        int numberOfPC = 0;

        while (freeSpase > PCVolume && variable != "Done")
        {
            variable = Console.ReadLine();

            if (variable != "Done")
            {
                numberOfPC = int.Parse(variable);
                PCVolume = PCVolume + numberOfPC;
            }
        }

        if (variable == "Done")
        {
            Console.WriteLine($"{freeSpase - PCVolume} Cubic meters left.");
        }
        else
        {
            Console.WriteLine($"No more free space! You need {PCVolume - freeSpase} Cubic meters more.");
        }

    }
}