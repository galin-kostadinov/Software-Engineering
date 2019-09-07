using System;

class EinsteinsRiddle
{
    static string[] houses = { "Red", "Green", "Yellow", "White", "Blue" };
    static string[] pets = { "Dog", "Cat", "Bird", "Horse", "Fish" };
    static string[] nationalities = { "Brit", "Swede", "Dane", "Norwegian", "German" };
    static string[] cigarettes = { "Blend", "Prince", "Dunhill", "BlueMaster", "PullMall" };
    static string[] drinks = { "Tea", "Coffee", "Milk", "Beer", "Water" };
    static string[] hints = new string[15];

    static void Main(string[] args)
    {
        Random rand = new Random();
        Stuffle(rand);
        GenerateHints();
        Console.WriteLine("Einstein's riddle");
        Console.WriteLine();
        Console.WriteLine("The situation:");
        Console.WriteLine("  1. There are 5 houses in five different colors.");
        Console.WriteLine("  2. In each house lives a person with a different nationality.");
        Console.WriteLine("  3. These five owners drink a certain type of beverage, smoke a certain brand of cigar and keep a certain pet.");
        Console.WriteLine("  4. No owners have the same pet, smoke the same brand of cigar or drink the same beverage.");
        Console.WriteLine();
        Console.WriteLine($"The question is: Who owns the {pets[3]}?");
        Console.WriteLine();
        Console.WriteLine("Hints:");
        for (int i = 1; i <= hints.Length; i++)
        {
            Console.WriteLine($"{i}. {hints[i - 1]}");
        }
        Console.WriteLine();
        Console.WriteLine("Einstein wrote this riddle this century. He said that 98% of the world could not solve it.");
        Console.WriteLine();
        Console.WriteLine("To see the solution type solution");

        string solution = Console.ReadLine();

        while (solution.ToLower() != "solution")
        {
            Console.WriteLine("Whrong command! Try again!");
            solution = Console.ReadLine();
        }
        PrintSolution();
    }

    private static void PrintSolution()
    {
        for (int i = 0; i < 5; i++)
        {
            Console.WriteLine($"In the {houses[i]} lives the {nationalities[i]}. He drinks {drinks[i]}, smoke {cigarettes[i]} and has {pets[i]} as a pet.");
        }
    }

    private static void GenerateHints()
    {
        hints[0] = $"the {nationalities[2]} lives in the {houses[2]} house";
        hints[1] = $"the {nationalities[4]} keeps {pets[4]} as pets";
        hints[2] = $"the {nationalities[1]} drinks {drinks[1]}";
        hints[3] = $"the {houses[3]} house is on the left of the {houses[4]} house";
        hints[4] = $"the {houses[3]} house's owner drinks {drinks[3]}";
        hints[5] = $"the person who smokes {cigarettes[2]} rears {pets[2]}";
        hints[6] = $"the owner of the {houses[0]} house smokes {cigarettes[0]}";
        hints[7] = $"the man living in the center house drinks {drinks[2]}";
        hints[8] = $"the {nationalities[0]} lives in the first house";
        hints[9] = $"the man who smokes {cigarettes[1]} lives next to the one who keeps {pets[0]}";
        hints[10] = $"the man who keeps {pets[1]} lives next to the man who smokes {cigarettes[0]}";
        hints[11] = $"the owner who smokes {cigarettes[4]} drinks {drinks[4]}";
        hints[12] = $"the {nationalities[3]} smokes {cigarettes[3]}";
        hints[13] = $"the {nationalities[0]} lives next to the {houses[1]} house";
        hints[14] = $"the man who smokes {cigarettes[1]} has a neighbor who drinks {drinks[0]}";
    }

    private static void Stuffle(Random rand)
    {
        for (int i = 0; i < 5; i++)
        {
            int randomHouseOne = rand.Next(0, houses.Length);
            int randomHouseTwo = rand.Next(0, houses.Length);
            Swap(randomHouseOne, randomHouseTwo, houses);

            int randomPetOne = rand.Next(0, pets.Length);
            int randomPetTwo = rand.Next(0, pets.Length);
            Swap(randomPetOne, randomPetTwo, pets);

            int randomNatioalitiesOne = rand.Next(0, pets.Length);
            int randomNationalitiesTwo = rand.Next(0, pets.Length);
            Swap(randomNatioalitiesOne, randomNationalitiesTwo, nationalities);

            int randomCigarettesOne = rand.Next(0, pets.Length);
            int randomCigarettesTwo = rand.Next(0, pets.Length);
            Swap(randomCigarettesOne, randomCigarettesTwo, cigarettes);

            int randomDrinksOne = rand.Next(0, pets.Length);
            int randomDrinksTwo = rand.Next(0, pets.Length);
            Swap(randomDrinksOne, randomDrinksTwo, drinks);
        }
    }

    private static void Swap(int randomOne, int randomTwo, string[] category)
    {
        string temp = category[randomOne];
        category[randomOne] = category[randomTwo];
        category[randomTwo] = temp;
    }
}

