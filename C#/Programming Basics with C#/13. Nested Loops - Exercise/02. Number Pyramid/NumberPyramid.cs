using System;

class NumberPyramid
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        int counter = 0;

        for (int rows = 1; rows <= n; rows++)
        {
            for (int columns = 1; columns <= rows; columns++)
            {

                ++counter;
                Console.Write(counter + " ");
                if (counter == n)
                {
                    break;
                }
            }

            Console.WriteLine();

            if (counter == n)
            {
                break;
            }
        }
    }
}
