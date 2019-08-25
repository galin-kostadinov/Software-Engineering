using System;

class GameStatistics
{
    static void Main()
    {
        string team = Console.ReadLine();
        string souvenir = Console.ReadLine();
        int numSouvenir = int.Parse(Console.ReadLine());
        double singelPrice = 0.0;
        double totalPrise = 0.0;

        switch (team)
        {
            case "Argentina":
                if (souvenir == "flags") singelPrice = 3.25;
                else if (souvenir == "caps") singelPrice = 7.20;
                else if (souvenir == "posters") singelPrice = 5.10;
                else if (souvenir == "stickers") singelPrice = 1.25;
                else Console.WriteLine("Invalid stock!");
                break;
            case "Brazil":
                if (souvenir == "flags") singelPrice = 4.2;
                else if (souvenir == "caps") singelPrice = 8.50;
                else if (souvenir == "posters") singelPrice = 5.35;
                else if (souvenir == "stickers") singelPrice = 1.20;
                else Console.WriteLine("Invalid stock!");
                break;
            case "Croatia":
                if (souvenir == "flags") singelPrice = 2.75;
                else if (souvenir == "caps") singelPrice = 6.9;
                else if (souvenir == "posters") singelPrice = 4.95;
                else if (souvenir == "stickers") singelPrice = 1.10;
                else Console.WriteLine("Invalid stock!");
                break;
            case "Denmark":
                if (souvenir == "flags") singelPrice = 3.1;
                else if (souvenir == "caps") singelPrice = 6.5;
                else if (souvenir == "posters") singelPrice = 4.8;
                else if (souvenir == "stickers") singelPrice = 0.9;
                else Console.WriteLine("Invalid stock!");
                break;
            default:
                Console.WriteLine("Invalid country!");
                break;
        }

        totalPrise = singelPrice * numSouvenir;

        if (totalPrise > 0)
        {
            Console.WriteLine($"Pepi bought {numSouvenir} {souvenir} of {team} for {totalPrise:F2} lv.");
        }
    }
}
