#include <iostream>
#include<string>
#include<sstream>
#include <stack>
#include <queue>

void readStack(std::stack<int> &currStack) {
    std::string line;
    getline(std::cin, line);
    std::istringstream lineStream(line);
    int currentNumber;
    while (lineStream >> currentNumber) {
        currStack.push(currentNumber);
    }
}

int main() {
    std::string line;
    std::stack<int> railcarA;
    std::stack<int> railcarB;
    std::stack<int> train;
    std::queue<char> AB_sequence;

    readStack(railcarA);
    readStack(railcarB);

    while (!railcarA.empty() || !railcarB.empty()) {
        if (!railcarA.empty() && !railcarB.empty()) {
            if (railcarA.top() < railcarB.top()) {
                train.push(railcarA.top());
                railcarA.pop();

                AB_sequence.push('A');
            } else {
                train.push(railcarB.top());
                railcarB.pop();

                AB_sequence.push('B');
            }
        } else if (!railcarA.empty()) {
            while (!railcarA.empty()) {
                train.push(railcarA.top());
                railcarA.pop();

                AB_sequence.push('A');
            }
        } else {
            while (!railcarB.empty()) {
                train.push(railcarB.top());
                railcarB.pop();

                AB_sequence.push('B');
            }
        }
    }

    while (!AB_sequence.empty()) {
        std::cout << AB_sequence.front();
        AB_sequence.pop();
    }
    std::cout << std::endl;

    while (!train.empty()) {
        std::cout << train.top() << " ";
        train.pop();
    }
    std::cout << std::endl;

    return 0;
}