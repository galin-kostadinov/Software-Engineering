using System;

class OldBooks
{
    static void Main()
    {
        string serchedbook = Console.ReadLine();
        int capacity = int.Parse(Console.ReadLine());
        string checkedBook = " ";
        int counter = 0;
        while (serchedbook != checkedBook && counter < capacity)
        {
            checkedBook = Console.ReadLine();
            ++counter;
        }
        if (serchedbook == checkedBook)
        {
            Console.WriteLine($"You checked {counter - 1} books and found it.");
        }
        else
        {
            Console.WriteLine("The book you search is not here!");
            Console.WriteLine($"You checked {counter} books.");
        }
    }
}
