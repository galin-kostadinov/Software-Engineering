#include<iostream>
#include <string>

using namespace std;

int main() {
    int cakeWidth, cakeLength;
    cin >> cakeWidth >> cakeLength;
    int numberOfCakePiece = cakeWidth * cakeLength;
    int inputPieceOfCake = 0;
    string input;
    while (numberOfCakePiece >= inputPieceOfCake && input != "STOP") {
        cin >> input;
        if (input != "STOP") {
            inputPieceOfCake = inputPieceOfCake + stoi(input);
        }
    }
    if (input == "STOP" && numberOfCakePiece >= inputPieceOfCake) {
        cout << numberOfCakePiece - inputPieceOfCake << " pieces are left." << endl;
    } else {
        cout << "No more cake left! You need " << inputPieceOfCake - numberOfCakePiece << " pieces more." << endl;
    }

    return 0;
}