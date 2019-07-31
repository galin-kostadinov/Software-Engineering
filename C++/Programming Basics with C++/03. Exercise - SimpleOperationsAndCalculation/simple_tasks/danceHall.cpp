#include <iostream>
#include <cmath>

using namespace std;

int main() {
    double lengthHall, widthHall, wardrobeSide;
    cin >> lengthHall >> widthHall >> wardrobeSide;

    double hallAreaMeters = lengthHall * widthHall * 100 * 100;
    double wardrobeAreaMeters = wardrobeSide * wardrobeSide * 100 * 100;
    double benchArea = hallAreaMeters / 10;
    double neededAreaToPerson = 7000 + 40;
    double personsCount = (hallAreaMeters - wardrobeAreaMeters - benchArea) / neededAreaToPerson;

    cout << floor(personsCount);

    return 0;
}