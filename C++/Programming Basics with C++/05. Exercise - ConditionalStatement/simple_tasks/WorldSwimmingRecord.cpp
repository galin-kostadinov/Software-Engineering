#include <iostream>
#include <cmath>

using namespace std;

int main() {
    double worldRecord, distance, speed;
    cin >> worldRecord >> distance >> speed;

    double delay = floor(distance / 15) * 12.5;
    double totalTime = distance * speed + delay;

    cout.setf(iostream::fixed);
    cout.precision(2);

    if (worldRecord > totalTime) {
        cout << "Yes, he succeeded! The new world record is " << totalTime << " seconds." << endl;
    } else {
        cout << "No, he failed! He was " << totalTime - worldRecord << " seconds slower." << endl;
    }

    return 0;
}