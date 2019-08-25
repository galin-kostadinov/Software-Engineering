using System;

class Spaceship
{
    static void Main()
    {
        double shipWidth = double.Parse(Console.ReadLine());
        double shipLength = double.Parse(Console.ReadLine());
        double shipHight = double.Parse(Console.ReadLine());
        double averagePeopleHight = double.Parse(Console.ReadLine());

        double shipVolume = shipWidth * shipLength * shipHight;

        double roomVolume = (averagePeopleHight + 0.4) * 2 * 2;
        int maxPeople = (int)Math.Floor(shipVolume / roomVolume);

        if (maxPeople >= 3 && maxPeople <= 10)
        {
            Console.WriteLine($"The spacecraft holds {maxPeople} astronauts.");
        }
        else if (maxPeople < 3)
        {
            Console.WriteLine("The spacecraft is too small.");
        }
        else if (maxPeople > 10)
        {
            Console.WriteLine("The spacecraft is too big.");
        }
    }
}