using System;

class Moving
{
    static void Main()
    {
        int freeSpaceWidth = int.Parse(Console.ReadLine());
        int freeSpacеLenght = int.Parse(Console.ReadLine());
        int freeSpacеHight = int.Parse(Console.ReadLine());
        int freeSpase = freeSpaceWidth * freeSpacеLenght * freeSpacеHight;
        int cartonVolume = 0;
        var variable = "variable";
        int numberOfCarton = 0;


        while (freeSpase > cartonVolume && variable != "Done")
        {
            variable = Console.ReadLine();
            if (variable != "Done")
            {
                numberOfCarton = int.Parse(variable);
                cartonVolume = cartonVolume + numberOfCarton;
            }
        }
        if (variable == "Done")
        {
            Console.WriteLine($"{freeSpase - cartonVolume} Cubic meters left.");
        }
        else
        {
            Console.WriteLine($"No more free space! You need {cartonVolume - freeSpase} Cubic meters more.");
        }
    }
}
