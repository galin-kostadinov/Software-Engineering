using System;
using System.Text;
using System.Diagnostics;

namespace _13._StringBulder
{
    class Program
    {
        static void Main()
        {
            StringBuilder sb = new StringBuilder();

            sb.Append("Ivan");
            sb.Append(" ");
            sb.Append("Pesho");
            sb.Append(" ");
            sb.Append("Maria");

            string result1 = sb.ToString();

            Console.WriteLine(result1);

            StringBuilder sb1 = new StringBuilder();

            sb1.AppendLine("Ivan");

            sb1.AppendLine("Pesho");

            sb1.AppendLine("Maria");

            int lenght = sb.Length;

            Console.WriteLine(sb1[1]);
            sb1[1]=5;

            sb1.Clear();

            string result1 = sb1.ToString();

            //////

            Stopwatch sw = Stopwatch.StartNew();

            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < 100; i++)
            {
                sb2.Append("+");
            }
            Console.WriteLine(sw.Elapsed);

            var sw = Stopwatch.StartNew();
            var result = string.Empty;
            for (int i = 0; i < 100; i++)
            {
                result += "+";
            }

            Console.WriteLine(sw.Elapsed);

            Console.WriteLine(sb.ToString());
            Console.WriteLine(result);
        }
    }
}
