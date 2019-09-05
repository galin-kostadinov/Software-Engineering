#include<iostream>
#include <cmath>

using namespace std;

int main() {
    double a, b, c;
    cin >> a >> b >> c;

    double discriminant = b * b - 4 * a * c;

    if (discriminant < 0) {
        cout << "no roots" << endl;

    } else if (discriminant == 0) {
        double x = -b / (2.0 * a);

        cout << x << endl;
    } else {
        double x2 = (-b - sqrt(discriminant)) / (2.0 * a);
        double x1 = (-b + sqrt(discriminant)) / (2.0 * a);

        cout << x2 << " " << x1 << endl;
    }

    return 0;
}
