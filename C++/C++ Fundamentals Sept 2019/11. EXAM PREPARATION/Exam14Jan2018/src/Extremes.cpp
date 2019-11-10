#include <iostream>
#include <algorithm>
#include <deque>
#include <numeric>
#include <cmath>

using namespace std;

int main() {
    int extremesDistance;
    int numberOfIncomes;

    cin >> extremesDistance >> numberOfIncomes;

    deque<int> initSeqNumbers(numberOfIncomes);

    int size = (int) initSeqNumbers.size();

    for (int i = 0; i < size; ++i) {
        cin >> initSeqNumbers[i];
    }

    sort(initSeqNumbers.begin(), initSeqNumbers.end());

    int min = initSeqNumbers.front();
    int max = initSeqNumbers.back();

    initSeqNumbers.pop_front();
    initSeqNumbers.pop_back();

    while (true) {
        int diff = abs(initSeqNumbers.front() - min);

        if (diff <= extremesDistance) {
            initSeqNumbers.pop_front();
        } else {
            break;
        }
    }

    while (true) {
        int diff = abs(initSeqNumbers.back() - max);

        if (diff <= extremesDistance) {
            initSeqNumbers.pop_back();
        } else {
            break;
        }
    }

    int sum = std::accumulate(initSeqNumbers.begin(), initSeqNumbers.end(), 0);
    cout << sum / (initSeqNumbers.size() * 1.0) << endl;

    return 0;
}
