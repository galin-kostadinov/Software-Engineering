#include <iostream>
#include <vector>

void print(std::vector<int> &variations) {
    for (int v: variations) {
        std::cout << v << ' ';
    }
    std::cout << std::endl;
}

void permute(const int index, std::vector<int> &elements, std::vector<bool> &used, std::vector<int> &variations) {
    if (index >= variations.size()) {
        print(variations);
    } else {
        for (int i = 0; i < elements.size(); ++i) {
            if (!used[i]) {
                int currentElement = elements[i];
                used[i] = true;
                variations[index] = currentElement;
                permute(index + 1, elements, used, variations);
                used[i] = false;
            }
        }
    }
}

int main() {
    const int PLACES_NUMBER = 2;
    std::vector<int> elements{1, 2, 3, 4};
    std::vector<bool> used(elements.size());
    std::vector<int> variations(PLACES_NUMBER);

    permute(0, elements, used, variations);

    return 0;
}