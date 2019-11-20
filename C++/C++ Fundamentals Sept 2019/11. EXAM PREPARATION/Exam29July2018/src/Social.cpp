#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <set>
#include <string>

typedef std::unordered_map<std::string, std::unordered_set<std::string> > mapOfSets;

void readIdsAndProfessions(std::unordered_map<std::string, std::string> &idProfession) {
    std::string line;
    std::string id;
    std::string profession;

    while (getline(std::cin, line) && line != "---") {
        id = line.substr(0, line.find(' '));
        profession = line.substr(line.find(' ') + 1);

        idProfession[id] = profession;
    }
}

void print(std::set<std::string> &foundedSuggestion) {
    if (foundedSuggestion.empty()) {
        std::cout << '-';
    } else {
        for (const std::string &curr:foundedSuggestion) {
            std::cout << curr << ' ';
        }
    }
    std::cout << std::endl;
}

void readFriends(mapOfSets &idFriends) {
    std::string line;
    std::string firstId;
    std::string secondId;

    while (getline(std::cin, line) && line != "---") {
        firstId = line.substr(0, line.find(' '));
        secondId = line.substr(line.find(' ') + 1);

        if (idFriends.find(firstId) == idFriends.end()) {
            std::unordered_set<std::string> friends{secondId};
            idFriends.emplace(std::make_pair(firstId, friends));
        } else {
            idFriends.find(firstId)->second.insert(secondId);
        }

        if (idFriends.find(secondId) == idFriends.end()) {
            std::unordered_set<std::string> friends{firstId};
            idFriends.emplace(std::make_pair(secondId, friends));
        } else {
            idFriends.find(secondId)->second.insert(firstId);
        }
    }
}

void findSuggestions(std::string &me, std::string &myProfession,
                     std::set<std::string> &foundedSuggestions, std::unordered_set<std::string> &isCheck,
                     std::string &currSuggestion, mapOfSets &idFriends,
                     std::unordered_map<std::string, std::string> &idProfession) {

    if (isCheck.find(currSuggestion) != isCheck.end()) {
        return;
    } else if (!currSuggestion.empty()) {
        isCheck.emplace(currSuggestion);
    }

    if (currSuggestion.empty()) {
        std::unordered_set<std::string> myFriendsSet = idFriends[me];

        for (std::string myFriend : myFriendsSet) {
            findSuggestions(me, myProfession, foundedSuggestions, isCheck,
                            myFriend, idFriends, idProfession);
        }
    } else {
        std::unordered_set<std::string> friendsToMyFriend = idFriends[currSuggestion];

        for (std::string currFriend: friendsToMyFriend) {
            if (idProfession[currFriend] == myProfession &&
                idFriends[currFriend].find(me) == idFriends[currFriend].end() &&
                currFriend != me) {

                foundedSuggestions.emplace(currFriend);
            }

            findSuggestions(me, myProfession, foundedSuggestions, isCheck,
                            currFriend, idFriends, idProfession);
        }
    }
}

void search(std::unordered_map<std::string, std::string> &idProfession, mapOfSets &idFriends) {
    std::string me;
    while (getline(std::cin, me) && me != "---") {
        std::string myProfession = idProfession.find(me)->second;;
        std::set<std::string> foundedSuggestions;
        std::unordered_set<std::string> isCheck;

        std::string currSuggestion;
        findSuggestions(me, myProfession, foundedSuggestions, isCheck, currSuggestion,
                        idFriends, idProfession);

        print(foundedSuggestions);
    }
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::unordered_map<std::string, std::string> idProfession;
    mapOfSets idFriends;

    readIdsAndProfessions(idProfession);
    readFriends(idFriends);
    search(idProfession, idFriends);

    return 0;
}