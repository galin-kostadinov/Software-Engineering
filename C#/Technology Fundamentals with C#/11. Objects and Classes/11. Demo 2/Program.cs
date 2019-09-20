using System;

namespace Demo

{

    public class Cat
    {
        public string Name { get; set; }

        public int Age { get; set; }

        public string Color { get; set; }


        public bool IsSleeping { get; set; }

        public void GoToSleep()
        {
            if (!IsSleeping)
            {
                IsSleeping = true;
            }
        }

        public void WakeUp()
        {
            if (IsSleeping)
            {
                IsSleeping = false;
            }
        }

        public string SayHello()
        {
            return $"Hello. I am a horse. My name is: {Name} and I am {Age} years old.";
        }

        public void GrowOlder()
        {
            Age++;
            if (Age > 25)
            {
                //Remove cat from the field
            }
        }
    }

    public class Program
    {
        public static void Main()
        {
            var firsCat = new Cat
            {
                Name = "Ivan",
                Age = 6,
                Color = "Black"
            };

            var secondCat = new Cat
            {
                Name = firsCat.Name,
                Age = firsCat.Age
            };

            ChangeName(firsCat);

            Console.WriteLine(firsCat.Name);

        }
        public static void ChangeName(Cat cat)
        {
            cat.Name = "Pesho";
        }
    }
}
