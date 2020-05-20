#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <sstream>

std::map<int, int> choiceCoin(std::vector<int> &coins, const int targetSum) {
    std::sort(coins.begin(), coins.end(), std::greater<int>());
    std::map<int, int> result;

    int coinIndex = 0;
    int currentSum = 0;
    while (coinIndex < coins.size() && currentSum < targetSum) {
        int coin = coins[coinIndex];
        int coinToTake = (targetSum - currentSum) / coin;

        if (coinToTake > 0) {
            result[coin] = coinToTake;
            currentSum += coinToTake * coin;
        }

        coinIndex++;
    }

    if (currentSum < targetSum) {
        throw std::invalid_argument("Coin set is not valid. Is not possible to return the target sum.");
    }

    return result;
}

void printResult(std::map<int, int> &coinsCount) {
    for (std::pair<int, int> coinCount :coinsCount) {
        std::cout << coinCount.second << " x " << coinCount.first << std::endl;
    }
}

void readCoins(std::vector<int> &coins) {
    std::string coinsAsString;
    std::getline(std::cin, coinsAsString);
    std::istringstream iss(coinsAsString);

    int coin;
    while (iss >>coin){
        coins.push_back(coin);
    }
}

int main() {
//    std::vector<int> coins{1, 2, 5, 10, 20, 50};

    std::vector<int> coins;
    std::cout << "Please enter coin set(1 2 5 10):" << std::endl;
    readCoins(coins);

    int targetSum;
    std::cout << "Please enter target sum:" << std::endl;
    std::cin >> targetSum;

    std::map<int, int> result = choiceCoin(coins, targetSum);
    printResult(result);

    return 0;
}