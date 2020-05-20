#include <iostream>
#include <vector>

void print(std::vector<int> &permutations) {
    for (int permutation: permutations) {
        std::cout << permutation << ' ';
    }
    std::cout << std::endl;
}

void permute(const int index, std::vector<int> &elements, std::vector<bool> &used, std::vector<int> &permutations) {
    if (index >= elements.size()) {
        print(permutations);
    } else {
        for (int i = 0; i < elements.size(); ++i) {
            if (!used[i]) {
                int currentElement = elements[i];
                used[i] = true;
                permutations[index] = currentElement;
                permute(index + 1, elements, used, permutations);
                used[i] = false;
            }
        }
    }
}

int main() {
    std::vector<int> elements{1, 2, 3, 4};
    std::vector<bool> used(elements.size());
    std::vector<int> permutations(elements.size());

    permute(0, elements, used, permutations);

    return 0;
}