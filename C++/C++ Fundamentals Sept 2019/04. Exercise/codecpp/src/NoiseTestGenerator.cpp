#include <iostream>
#include <vector>
#include<cstdlib>
#include <ctime>
#include<cctype>

using namespace std;

char generateRandomSymbol() {
    int randomNumber = rand();
    char symbol = randomNumber % 255;
    return symbol;
}

void print(const vector<char> &randomText) {
    int size = (int) randomText.size();

    for (int i = 0; i < size; ++i) {
        char currentChar = randomText[i];
        if (isprint(currentChar)) {
            cout << currentChar;
        }
    }

    cout << endl;
}

int main() {
    srand(time(NULL));

    int digitCounter = 0;

    vector<char> randomText;

    while (true) {
        char symbol = generateRandomSymbol();

        if (symbol == '.' && digitCounter > 0) {
            randomText.push_back(symbol);
            break;
        }

        if (symbol != '.') {
            randomText.push_back(symbol);

            if (isdigit(symbol)) {
                digitCounter++;
                if (digitCounter >= 18) {
                    randomText.push_back('.');
                    break;
                }
            }
        }
    }

    print(randomText);

    return 0;
}