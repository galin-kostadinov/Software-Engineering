using System;

namespace Demo
{
    public struct Cat// struct is NOT reference type. class is reference type
    {
        public string Name { get; set; }
    }
    //string is only one class who have behaviar as struct
    class Program
    {
        static void Main()
        {
            char[] symbols = new[] { 'a', 'b', 'c' };

            var text = new string(symbols);
            Console.WriteLine(text);

            var text1 = new string('a', 100);
            Console.WriteLine(text1);

            string greet = "Hello";
            string name = "John";
            string result = string.Concat(greet, name);

            var text3 = "Hello world!";
            int indexOfO = text3.IndexOf("o", 5);// return -1 if element not found
            Console.WriteLine(indexOfO);
            
            string newText3 = text3.Substring(3, 4);

            text3.Remove(5, 2);
        }
    }
}
