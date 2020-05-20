#include <iostream>
#include <vector>

void print(std::vector<int> &elements) {
    for (int e: elements) {
        std::cout << e << ' ';
    }
    std::cout << std::endl;
}

void swap(const int first, const int second, std::vector<int> &elements) {
    int temp = elements[first];
    elements[first] = elements[second];
    elements[second] = temp;
}

void permute(const int index, std::vector<int> &elements) {
    if (index >= elements.size()) {
        print(elements);
    } else {
        permute(index + 1, elements);

        for (int i = index + 1; i < elements.size(); ++i) {
            swap(index, i, elements);
            permute(index + 1, elements);
            swap(index, i, elements);
        }
    }
}

int main() {
    std::vector<int> elements{1, 2, 3, 4};

    permute(0, elements);

    return 0;
}