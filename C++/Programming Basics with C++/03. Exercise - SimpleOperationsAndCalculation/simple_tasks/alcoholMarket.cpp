#include <iostream>

using namespace std;

int main() {
    double whiskeyPrice, beerLiters, wineLiters, rakiyaLiters, whiskeyLiters;
    cin >> whiskeyPrice >> beerLiters >> wineLiters >> rakiyaLiters >> whiskeyLiters;

    double totalPrice = whiskeyPrice * whiskeyLiters + beerLiters * whiskeyPrice * 0.5 * (1 - 0.8)
                        + wineLiters * whiskeyPrice * 0.5 * (1 - 0.4) + rakiyaLiters * whiskeyPrice * 0.5;

    cout.setf(ios::fixed);
    cout.precision(2);
    cout << totalPrice << endl;

    return 0;
}