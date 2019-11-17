#include <iostream>
#include <vector>

class Student {
private:
    std::string name;
    std::string surname;
    double average;

public:
    Student(std::string name, std::string surname, double average) : name(name), surname(surname), average(average) {
    }

    void printStudentInfo() const {
        std::cout << this->name << " " << this->surname << " " << this->average << std::endl;
    }

    friend double calculateAverage(std::vector<Student> const &students);
};

double calculateAverage(std::vector<Student> const &students) {
    if (students.empty()) {
        return 0;
    }

    double averageForAll = 0;

    for (const auto &student : students) {
        averageForAll += student.average;
    }

    return averageForAll / students.size();
}

int main() {
    int studentsCount;
    std::cin >> studentsCount;

    std::vector<Student> students;

    std::string name;
    std::string surname;
    double average;

    while (studentsCount-- > 0) {
        std::cin >> name >> surname >> average;
        students.emplace_back(name, surname, average);
    }

    for (const auto &student : students) {
        student.printStudentInfo();
    }

    std::cout << calculateAverage(students);

    return 0;
}