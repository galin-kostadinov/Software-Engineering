#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    int counter = 0;

    for (int rows = 1; rows <= n; rows++) {
        for (int columns = 1; columns <= rows; columns++) {

            ++counter;
            cout << counter << " ";
            if (counter == n) {
                break;
            }
        }

        cout << endl;

        if (counter == n) {
            break;
        }
    }

    return 0;
}
