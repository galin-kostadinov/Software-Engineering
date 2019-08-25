using System;

class NumberSequence
{
    static void Main()
    {
        int smallest = int.MaxValue;
        int biggest = int.MinValue;

        while (true)
        {
            string command = Console.ReadLine();
            if (command == "END")
            {
                break;
            }
            int num = int.Parse(command);

            if (biggest < num)
            {
                biggest = num;
            }
            if (smallest > num)
            {
                smallest = num;
            }
        }
        Console.WriteLine($"Max number: {biggest}");
        Console.WriteLine($"Min number: {smallest}");
    }
}
