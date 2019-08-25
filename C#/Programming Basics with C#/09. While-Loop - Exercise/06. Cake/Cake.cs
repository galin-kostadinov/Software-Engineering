using System;

class Cake
{
    static void Main()
    {
        int cakeWidth = int.Parse(Console.ReadLine());
        int cakeLenght = int.Parse(Console.ReadLine());
        int numberOfCakePiece = cakeWidth * cakeLenght;
        int inputPieceOfCake = 0;
        string input = "variable";
        while (numberOfCakePiece >= inputPieceOfCake && input != "STOP")
        {
            input = Console.ReadLine();
            if (input != "STOP")
            {
                inputPieceOfCake = inputPieceOfCake + int.Parse(input);
            }
        }
        if (input == "STOP" && numberOfCakePiece >= inputPieceOfCake)
        {
            Console.WriteLine($"{numberOfCakePiece - inputPieceOfCake} pieces are left.");
        }
        else
        {
            Console.WriteLine($"No more cake left! You need {inputPieceOfCake - numberOfCakePiece} pieces more.");
        }
    }
}
