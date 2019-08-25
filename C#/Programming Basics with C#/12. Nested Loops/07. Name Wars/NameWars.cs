using System;
using System.Text;

class NameWars
{
    static void Main()
    {
        int sum = 0;
        int sum1 = 0;
        string winner = " ";

        for (string name = Console.ReadLine(); name != "STOP"; name = Console.ReadLine())
        {

            byte[] asciiBytes = Encoding.ASCII.GetBytes(name);
            for (int i = 0; i < asciiBytes.Length; i++)
            {
                sum = sum + asciiBytes[i];
            }
            if (sum > sum1)
            {
                winner = name;
                sum1 = sum;
            }
            sum = 0;
        }
        Console.WriteLine($"Winner is {winner} - {sum1}!");
    }
}
