﻿using System;

namespace _03._ExtractFile
{
    class Program
    {
        static void Main()
        {
            string path = Console.ReadLine();
            int startIndexOfFile = path.LastIndexOf('\\') + 1;
            string file = path.Substring(startIndexOfFile);
            int startIndexOfExtension = file.LastIndexOf('.') + 1;
            string name = file.Substring(0, startIndexOfExtension - 1);
            string extension = file.Substring(startIndexOfExtension);

            Console.WriteLine($"File name: {name}");
            Console.WriteLine($"File extension: {extension}");
        }
    }
}
