#include<iostream>

using namespace std;

int main() {

    int numOfFloors, numOfRooms;
    cin >> numOfFloors >> numOfRooms;

    char prefix = ' ';
    int room = 0;

    for (int i = numOfFloors - 1; i >= 0; i--) {
        for (int j = 0; j < numOfRooms; j++) {
            if (i % 2 == 0 && i < numOfFloors - 1 && numOfFloors > 1) {
                prefix = 'A';
            } else if (i % 2 != 0 && i < numOfFloors - 1 && numOfFloors > 1) {
                prefix = 'O';
            } else {
                prefix = 'L';
            }

            room = (i + 1) * 10 + j;

            if (j == numOfRooms - 1) {
                cout << prefix << room << endl;
            } else {
                cout << prefix << room << " ";
            }
        }
    }

    return 0;
}