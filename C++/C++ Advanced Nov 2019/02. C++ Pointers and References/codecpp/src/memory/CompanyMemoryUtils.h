#ifndef CODECPP_COMPANYMEMORYUTILS_H
#define CODECPP_COMPANYMEMORYUTILS_H


std::vector<Company> readCompaniesFromMemory(unsigned char *memory, const int numCompanies) {
    std::vector<Company> result;

    int id = 0;
    std::string name;
    std::vector<std::pair<char, char> > employees;
    int employeesCount = 0;

    for (int i = 0; i < numCompanies; ++i) {
        id = *memory;
        memory++;

        while (*memory != '\000') {
            name.push_back(*memory);
            memory++;
        }

        memory++;
        employeesCount = *memory;

        while (employeesCount-- > 0) {
            memory++;
            char firts = (char) *memory;
            memory++;
            char second = (char) *memory;

            employees.emplace_back(std::make_pair(firts, second));
        }

        result.emplace_back(Company(id, name, employees));

        employees.clear();
        name.clear();

        memory++;
    }

    return result;
}

#endif //CODECPP_COMPANYMEMORYUTILS_H

