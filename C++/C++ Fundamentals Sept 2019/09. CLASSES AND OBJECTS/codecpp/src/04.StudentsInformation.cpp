#include <iostream>

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
};

int main() {
    int studentsCount;
    std::cin >> studentsCount;

    std::string name;
    std::string surname;
    double average;

    while (studentsCount-- > 0) {
        std::cin >> name >> surname >> average;
        Student student{name, surname, average};
        student.printStudentInfo();
    }

    return 0;
}