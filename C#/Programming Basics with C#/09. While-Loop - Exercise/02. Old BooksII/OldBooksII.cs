using System;

class OldBooksII
{
    static void Main()
    {
        string serchedbook = Console.ReadLine();
        int capacity = int.Parse(Console.ReadLine());
        int counterChekedBook = 0;
        while (capacity > 0)
        {
            string checkedBook = Console.ReadLine();

            if (checkedBook == serchedbook)
            {
                Console.WriteLine($"You checked {counterChekedBook} books and found it.");
                break;
            }
            else
            {
                counterChekedBook++;
                capacity--;
            }
        }

        if (capacity == 0)
        {
            Console.WriteLine("The book you search is not here!");
            Console.WriteLine($"You checked {counterChekedBook} books.");
        }
    }
}
