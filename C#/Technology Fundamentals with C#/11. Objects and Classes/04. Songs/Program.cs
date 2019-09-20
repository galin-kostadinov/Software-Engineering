using System;
using System.Collections.Generic;
using System.Linq;

namespace _04._Songs
{
    public class Song
    {
        public string TypeList { get; set; }

        public string Name { get; set; }

        public string Time { get; set; }
    }

    public class Program
    {
        public static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            List<Song> songs = new List<Song>();

            for (int i = 0; i < n; i++)
            {
                string[] data = Console.ReadLine().Split("_");

                string type = data[0];
                string name = data[1];
                string time = data[2];

                Song song = new Song
                {
                    TypeList = type,
                    Name = name,
                    Time = time
                };
                songs.Add(song);
            }
            string songsForPtint = Console.ReadLine();
            if (songsForPtint == "all")
            {
                foreach (var song in songs)
                {
                    Console.WriteLine(song.Name);
                }
            }
            else
            {
                var filtredSongs = songs
                .Where(x => x.TypeList == songsForPtint)
                .ToList();

                foreach (var song in filtredSongs)
                {
                    Console.WriteLine(song.Name);
                }
            }
        }
    }
}
