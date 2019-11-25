using System;
using System.Linq;

namespace Extract_File
{
    class Program
    {
        static void Main()
        {
            string[] path = Console.ReadLine().Split('\\');
            string[] fileNameAndExtention = path[path.Length - 1].Split('.');
            Console.WriteLine($"File name: {fileNameAndExtention[0]}");
            Console.WriteLine($"File extension: {fileNameAndExtention[1]}");
        }
    }
}
