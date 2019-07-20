#include <iostream>

using namespace std;

int main() {

    int length;
    int width;
    int height;
    double percent;

    cin >> length >> width >> height >> percent;

    double volumeWater;

    volumeWater = 0.001*length*width*height*(1-percent*0.01);

    cout.setf(ios::fixed);
    cout.precision(3);
    cout << volumeWater;
    return 0;
}