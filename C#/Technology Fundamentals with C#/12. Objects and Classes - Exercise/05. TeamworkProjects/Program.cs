using System;
using System.Collections.Generic;
using System.Linq;

namespace TeamworkProjects
{
    public class Team
    {
        public Team(string name, string creatorName)
        {
            Name = name;
            CreatorName = creatorName;
            Members = new List<string>();
        }

        public string Name { get; set; }

        public string CreatorName { get; set; }

        public List<string> Members { get; set; }
    }
    public class Program
    {
        public static void Main()
        {
            int teamsCount = int.Parse(Console.ReadLine());

            List<Team> teams = new List<Team>();

            for (int i = 0; i < teamsCount; i++)
            {
                var teamProp = Console.ReadLine().Split("-").ToList();
                string creatorName = teamProp[0];
                string teamName = teamProp[1];

                //bool isTeamNameExist = teams.Select(x => x.Name).Contains(teamName);
                bool isTeamNameExist = teams.Any(x => x.Name == teamName);

                bool isCreatorNameExist = teams.Any(x => x.CreatorName == creatorName);

                if (isTeamNameExist)
                {
                    Console.WriteLine($"Team {teamName} was already created!");
                }
                if (isCreatorNameExist)
                {
                    Console.WriteLine($"{creatorName} cannot create another team!");
                }
                if (!isTeamNameExist && !isCreatorNameExist)
                {
                    Team team = new Team(teamName, creatorName);
                    teams.Add(team);
                    Console.WriteLine($"Team {teamName} has been created by {creatorName}!");
                }
            }

            while (true)
            {
                string input = Console.ReadLine();

                if (input == "end of assignment")
                {
                    break;
                }

                var splitedInput = input.Split("->").ToList();
                string user = splitedInput[0];
                string teamName = splitedInput[1];

                bool isTeamExist = teams.Any(x => x.Name == teamName);
                bool isExistMember = teams.Any(x => x.Members.Contains(user) || x.CreatorName == user);


                if (isTeamExist == false)
                {
                    Console.WriteLine($"Team {teamName} does not exist!");
                }
                else if (isExistMember)
                {
                    Console.WriteLine($"Member {user} cannot join team {teamName}!");
                }
                if (isTeamExist && isExistMember == false)
                {
                    int indexOfTeam = teams.FindIndex(x => x.Name == teamName);
                    teams[indexOfTeam].Members.Add(user);
                }
            }

            List<Team> teamsWhitMembers = teams
                .Where(x => x.Members.Count > 0)
                .OrderByDescending(x => x.Members.Count)
                .ThenBy(x => x.Name)
                .ToList();

            List<Team> teamsWhitoutMembers = teams
                .Where(x => x.Members.Count == 0)
                .OrderBy(x => x.Name)
                .ToList();

            foreach (var team in teamsWhitMembers)
            {
                Console.WriteLine(team.Name);
                Console.WriteLine($"- {team.CreatorName}");
                Console.WriteLine(string.Join(Environment.NewLine, team.Members.OrderBy(x => x).Select(x => $"-- {x}")));
            }
            Console.WriteLine("Teams to disband:");
            foreach (var team in teamsWhitoutMembers)
            {
                Console.WriteLine(team.Name);

            }
        }
    }
}
