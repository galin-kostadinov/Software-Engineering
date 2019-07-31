#include <iostream>
#include <string>

using namespace std;

int main() {
    int width, length, high;
    cin >> width >> length >> high;

    int freeSpace = width * length * high;
    int cartonVolume = 0;

    string command;
    cin >> command;
    while (command != "Done") {
        int numberOfCarton = stoi(command);
        cartonVolume += numberOfCarton;
        if (freeSpace <= cartonVolume) {
            break;
        }
        cin >> command;
    }
    if (command == "Done") {
        cout << (freeSpace - cartonVolume) << " Cubic meters left." << endl;
    } else {
        cout << "No more free space! You need " << (cartonVolume - freeSpace) << " Cubic meters more." << endl;
    }
    return 0;
}