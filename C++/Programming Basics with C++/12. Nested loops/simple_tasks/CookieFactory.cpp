#include<iostream>

using namespace std;

int main() {
    int batchNum;
    cin >> batchNum;
    string component = " ";

    for (int i = 1; i <= batchNum; i++) {
        bool flour = false;
        bool sugar = false;
        bool eggs = false;
        component = " ";

        while (component != "Bake!" || !flour || !sugar || !eggs) {
            cin >> component;

            if (component == "flour") {
                flour = true;
            } else if (component == "sugar") {
                sugar = true;
            } else if (component == "eggs") {
                eggs = true;
            } else if (component == "Bake!") {
                if (!(flour && sugar && eggs)) {
                    cout << "The batter should contain flour, eggs and sugar!" << endl;
                }
            }

        }

        cout << "Baking batch number " << i << "..." << endl;
    }

    return 0;
}