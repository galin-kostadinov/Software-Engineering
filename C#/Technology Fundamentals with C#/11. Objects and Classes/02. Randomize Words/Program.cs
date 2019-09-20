using System;

namespace _02._Randomize_Words
{
    public class Program
    {
        public static void Main()
        {
            var random = new Random();
            var words = Console.ReadLine().Split();

            for (int i = 0; i < words.Length; i++)
            {
                var ri = random.Next(0, words.Length);
                var tempValue = words[i];
                words[i] = words[ri];
                words[ri] = tempValue;
            }
            foreach (var word in words)
            {
                Console.WriteLine(word);
            }
        }
    }
}
