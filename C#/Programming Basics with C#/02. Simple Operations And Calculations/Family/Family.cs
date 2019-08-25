using System;


class Family
{
    static void Main()
    {
        string name = Console.ReadLine();
        string catName1 = Console.ReadLine();


        //simple way
        Console.WriteLine("My name is " + name + ". My first cat name is " + catName1 + ".");

        //string format {}
        Console.WriteLine("My name is {1}. My first cat name is {0}.", name, catName1);

        //string interpolation {variable}
        Console.WriteLine($"My name is {name}. My first cat name is {catName1}. {5 * 3}");
    }

}
