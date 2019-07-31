#include <iostream>

using namespace std;

int main() {
    double x1, y1, x2, y2, x, y;
    cin >> x1 >> y1 >> x2 >> y2 >> x >> y;

    bool firstCondition = ((x == x1 || x == x2) && (y >= y1 && y <= y2));
    bool secondCondition = ((y == y1 || y == y2) && (x >= x1 && x <= x2));

    if (firstCondition || secondCondition) {
        cout << "Border" << endl;
    } else {
        cout << "Inside / Outside" << endl;
    }

    return 0;
}