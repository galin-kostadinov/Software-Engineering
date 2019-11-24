using System;

namespace Demo1
{
    class Program
    {
        static void Main()
        {
            string text = "Hello world, Ivan";

            string[] parts = text
                .Split(new char[] { ',', ' ' }, StringSplitOptions.RemoveEmptyEntries);

            text = text.Replace("wo", "!??");
        }
    }
}
