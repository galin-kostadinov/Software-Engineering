#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>
#include <algorithm>
#include <utility>

using namespace std;

struct compare {
    inline bool operator()(std::pair<int, std::string> &a, std::pair<int, std::string> &b) {
        return a.first > b.first;
    }
};

string changeLetters(string s, unordered_map<char, char> letterChangeMap) {
    string changed(s.size(), ' ');
    int size = (int) s.size();

    for (int i = 0; i < size; i++) {
        char originalChar = s[i];
        if (isalpha(originalChar)) {
            /// NOTE: we know that every char will have a matching char
            changed[i] = letterChangeMap[originalChar];
        } else {
            changed[i] = originalChar;
        }
    }

    return changed;
}

void
createClearMessages(unordered_map<string, vector<string>> &roughMessages, vector<string> &readableMessageGroup,
                    const vector<unordered_map<char, char>> &encryptionKeys, const string &startWord) {
    vector<pair<int, string>> orderedMessagesByGroupSize;

    for (const auto &kvp:roughMessages) {
        orderedMessagesByGroupSize.emplace_back(kvp.second.size(), kvp.first);
    }

    sort(orderedMessagesByGroupSize.begin(), orderedMessagesByGroupSize.end(), greater<pair<int, string>>());

    int sizeOrderedMessages = orderedMessagesByGroupSize.size();
    for (int i = 0; i < sizeOrderedMessages; ++i) {
        bool isFound = false;
        int indexEncryptionKey = 0;
        for (size_t j = 0; j < encryptionKeys.size(); ++j) {
            if (changeLetters(orderedMessagesByGroupSize[i].second, encryptionKeys[j]) != startWord) {
                continue;
            } else {
                isFound = true;
                indexEncryptionKey = j;
                break;
            }
        }

        if (!isFound) {
            continue;
        }

        int sizeGroup = roughMessages[orderedMessagesByGroupSize[i].second].size();
        if (sizeGroup < readableMessageGroup.size()) {
            continue;
        }

        readableMessageGroup.clear();

        for (int k = 0; k < sizeGroup; ++k) {
            readableMessageGroup.emplace_back(
                    changeLetters(roughMessages[orderedMessagesByGroupSize[i].second][k],
                                  encryptionKeys[indexEncryptionKey]));
        }
    }
}

void createEncryptedMap(vector<unordered_map<char, char>> &encryptionKeys, string &encryption) {
    unordered_map<char, char> encryptionMap;
    int size = 26;
    for (int i = 0; i < size; i++) {
        char encryptedChar = encryption[i];
        char actualChar = 'a' + i;
        encryptionMap[encryptedChar] = actualChar;
    }

    encryptionKeys.emplace_back(encryptionMap);
}

void print(vector<string> &readableMessageGroup) {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    int size = (int) readableMessageGroup.size();

    for (int j = 0; j < size; ++j) {
        cout << readableMessageGroup[j] << endl;
    }
}

int main() {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    string startWord;
    getline(cin, startWord);

    unordered_map<string, vector<string>> roughMessages;
    vector<string> readableMessageGroup;

    int sizeStartWord = (int) startWord.size();

    string message;
    while (getline(cin, message) && message != "[encryptions]") {
        string key = message.substr(0, sizeStartWord);

        unordered_map<string, vector<string>>::iterator it = roughMessages.find(key);

        if (it == roughMessages.end()) {
            vector<string> group;
            group.emplace_back(message);
            roughMessages[key] = group;
        } else {
            (*it).second.emplace_back(message);
        }
    }

    vector<unordered_map<char, char>> encryptionKeys;
    string encryption;

    while (getline(cin, encryption) && encryption != "[end]") {
        createEncryptedMap(encryptionKeys, encryption);
    }

    if (!roughMessages.empty()) {
        createClearMessages(roughMessages, readableMessageGroup, encryptionKeys, startWord);
        print(readableMessageGroup);
    }

    return 0;
}
