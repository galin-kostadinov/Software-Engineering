#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <sstream>
#include <iomanip>

class Sale {
    std::string town;
    std::vector<std::string> products;
    std::vector<double> prices;
    std::vector<double> quantities;

public:
    Sale(std::string &town, std::string &product, double price, double quantity) : town(town) {
        this->addProduct(product, price, quantity);
    }

    void addProduct(std::string &product, double price, double quantity) {
        this->products.emplace_back(product);
        this->prices.emplace_back(price);
        this->quantities.emplace_back(quantity);
    }

    double getAmount() {
        double amount = 0;
        int size = (int) prices.size();
        for (int i = 0; i < size; ++i) {
            amount += prices[i] * quantities[i];
        }

        return amount;
    }

    std::string getInfo() {
        std::ostringstream oss;
        oss << this->town << " -> " << std::fixed << std::setprecision(2) << this->getAmount();

        return oss.str();
    }

    ~Sale() = default;
};

void print(std::map<std::string, Sale> &sales) {
    for (auto &sale : sales) {
        std::cout << sale.second.getInfo() << std::endl;
    }
}


int main() {
    int count;
    std::cin >> count;
    std::cin.ignore();

    std::map<std::string, Sale> sales;

    std::string town;
    std::string product;
    double price = 0.0;
    double quantity = 0.0;

    std::string line;
    while (count-- > 0) {
        getline(std::cin, line);
        std::vector<std::string> token;

        std::istringstream oss(line);
        std::string word;

        while (oss >> word) {
            token.emplace_back(word);
        }

        town = token[0];
        product = token[1];
        price = std::stod(token[2]);
        quantity = std::stod(token[3]);

        if (sales.find(town) == sales.end()) {
            sales.insert(std::pair<std::string, Sale>(town, Sale(town, product, price, quantity)));
        } else {
            sales.find(town)->second.addProduct(product, price, quantity);
        }
    }

    print(sales);

    return 0;
}