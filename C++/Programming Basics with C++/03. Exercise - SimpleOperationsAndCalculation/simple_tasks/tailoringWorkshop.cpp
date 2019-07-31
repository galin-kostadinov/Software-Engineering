#include <iostream>

using namespace std;

int main() {
    int tableCount;
    double tableLength;
    double tableWidth;

    cin >> tableCount >> tableLength >> tableWidth;

    double cloutArea = tableCount * (tableLength + 2 * 0.30) * (tableWidth + 2 * 0.30);
    double squareArea = tableCount * (tableLength / 2) * (tableLength / 2);

    double resultUSD = 7 * cloutArea + 9 * squareArea;
    double resultBGN = 1.85 * resultUSD;

    cout.setf(ios::fixed);
    cout.precision(2);
    cout << resultUSD << " USD" << endl;
    cout << resultBGN << " BGN" << endl;

    return 0;
}