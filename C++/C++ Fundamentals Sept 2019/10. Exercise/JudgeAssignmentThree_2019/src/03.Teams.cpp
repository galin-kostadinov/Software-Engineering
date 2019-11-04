#include <iostream>
#include <vector>
#include <map>

void read(std::map<std::string, std::vector<std::string>> &teams,
          std::map<std::string, int> &playersScore, const int numberOfTeams);

void calculateScore(std::map<std::string, std::vector<std::string>> &teams,
                    std::map<std::string, int> &playersScore, const int numberOfGames);

void print(const std::map<std::string, int> &playersScore);

int main() {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    int numberOfTeams;
    std::cin >> numberOfTeams;

    std::map<std::string, std::vector<std::string>> teams;
    std::map<std::string, int> playersScore;

    read(teams, playersScore, numberOfTeams);

    int numberOfGames;
    std::cin >> numberOfGames;

    calculateScore(teams, playersScore, numberOfGames);

    print(playersScore);

    return 0;
}

void read(std::map<std::string, std::vector<std::string>> &teams,
          std::map<std::string, int> &playersScore, const int numberOfTeams) {
    std::string team;
    int teamCount;
    std::string currentPlayer;
    for (int i = 0; i < numberOfTeams; ++i) {
        std::cin >> team;
        std::cin >> teamCount;

        std::vector<std::string> playersInTeam(teamCount);

        for (int j = 0; j < teamCount; ++j) {
            std::cin >> currentPlayer;
            playersInTeam[j] = currentPlayer;

            if (playersScore.find(currentPlayer) == playersScore.end()) {
                playersScore[currentPlayer] = 0;
            }
        }

        teams[team] = playersInTeam;
    }
}

void calculateScore(std::map<std::string, std::vector<std::string>> &teams,
                    std::map<std::string, int> &playersScore, const int numberOfGames) {
    std::string winnerTeam;

    for (int i = 0; i < numberOfGames; ++i) {
        std::cin >> winnerTeam;

        std::vector<std::string> players = teams[winnerTeam];

        for (const auto &player : players) {
            playersScore[player]++;
        }
    }
}

void print(const std::map<std::string, int> &playersScore) {
    for (const auto &score : playersScore) {
        std::cout << score.second << " ";

    }

    std::cout << std::endl;
}
