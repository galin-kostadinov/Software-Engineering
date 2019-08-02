#include <iostream>
#include <string>

using namespace std;

int main() {
    string text;
    getline(cin, text);
    int sum = 0;
    for (int i = 0; i < text.length(); i++) {
        char symbol = text[i];
        if (symbol == 'a') {
            sum += 1;
        } else if (symbol == 'e') {
            sum += 2;
        } else if (symbol == 'i') {
            sum += 3;
        } else if (symbol == 'o') {
            sum += 4;
        } else if (symbol == 'u') {
            sum += 5;
        }
    }
    cout << sum << endl;

    return 0;
}
