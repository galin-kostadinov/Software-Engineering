#include<iostream>
#include <string>

using namespace std;

int main() {
    string searchingBook;
    getline(cin, searchingBook);

    int capacity;
    cin >> capacity;
    cin.ignore();

    int counter = 0;
    bool isFound = false;
    while (counter < capacity) {
        string currentBook;
        getline(cin, currentBook);

        if (currentBook == searchingBook) {
            cout << "You checked " << counter << " books and found it." << endl;
            isFound = true;
            break;
        }

        counter++;
    }

    if (!isFound) {
        cout << "The book you search is not here!" << endl;
        cout << "You checked " << counter << " books." << endl;
    }
    return 0;
}