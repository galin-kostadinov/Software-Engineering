using System;

namespace _12._Constructor
{
    public class Cat
    {
        public Cat(string name)
        {
            ValidateCatName(name);

            this.Name = name;
        }

        public Cat(string name, int age)
        {
            if (age < 1)
            {
                throw new Exception("Cat age must be more than 0.");
            }
            ValidateCatName(name);

            this.Name = name;
            this.Age = age;
        }
        public string Name { get; set; }

        public int Age { get; set; }

        public string Color { get; set; }

        void ValidateCatName(string name)
        {
            if (name == null || name.Length < 2)
            {
                throw new Exception("Cat name is not valid. It should be more than 2 symbols long.");
            }
        }
    }


    class Program
    {
        static void Main()
        {
            var cat = new Cat("Ivan", 6);
            var someCat = new Cat("Misho", 4);
        }
    }
}
