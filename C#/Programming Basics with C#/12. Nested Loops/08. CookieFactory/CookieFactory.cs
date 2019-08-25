using System;

class CookieFactory
{
    static void Main()
    {
        int batchNum = int.Parse(Console.ReadLine());
        string component = " ";

        for (int i = 1; i <= batchNum; i++)
        {
            bool flour = false;
            bool sugar = false;
            bool eggs = false;
            component = " ";

            while (component != "Bake!" || !flour || !sugar || !eggs)
            {
                component = Console.ReadLine();
                if (component == "flour")
                {
                    flour = true;
                }
                else if (component == "sugar")
                {
                    sugar = true;
                }
                else if (component == "eggs")
                {
                    eggs = true;
                }
                else if (component == "Bake!")
                {
                    if (!(flour && sugar && eggs))
                    {
                        Console.WriteLine("The batter should contain flour, eggs and sugar!");
                    }
                }

            }

            Console.WriteLine($"Baking batch number {i}...");
        }
    }
}
