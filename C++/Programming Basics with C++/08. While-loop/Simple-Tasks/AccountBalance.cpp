#include <iostream>

using namespace std;

int main() {
    int number;
    cin >> number;
    int counter = 0;
    double accountBalance = 0;
    cout.setf(ios::fixed);
    cout.precision(2);
    while (counter < number) {
        double currentAmount;
        cin >> currentAmount;
        if(currentAmount<0){
            cout<<"Invalid operation!"<<endl;
            break;
        }
        accountBalance += currentAmount;
        cout << "Increase: " << currentAmount << endl;
        counter++;
    }
    cout << "Total: " << accountBalance << endl;
    return 0;
}