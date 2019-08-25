using System;

class VowelsSum
{
    static void Main()
    {
        string inputWord = Console.ReadLine();
        int wordLenght = inputWord.Length;
        int sum = 0;

        for (int i = 0; i <= wordLenght - 1; i++)
        {
            char charakter = inputWord[i];
            if (charakter == 'a')
            {
                sum = sum + 1;
            }
            else if (charakter == 'e')
            {
                sum = sum + 2;
            }
            else if (charakter == 'i')
            {
                sum = sum + 3;
            }
            else if (charakter == 'o')
            {
                sum = sum + 4;
            }
            else if (charakter == 'u')
            {
                sum = sum + 5;
            }
        }
        Console.WriteLine(sum);
    }
}

