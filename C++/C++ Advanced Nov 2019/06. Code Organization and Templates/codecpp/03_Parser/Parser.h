#ifndef PARSER_H
#define PARSER_H

#include <sstream>
#include <string>

template<typename T>
class Parser {
    std::istream &in;
    std::string stopLine;

public:
    Parser(std::istream &in, std::string &stopLine) : in(in), stopLine(stopLine) {}

    bool readNext(T &value) {
        std::string input;
        std::getline(in, input);

        if (input == stopLine) {
            return false;
        }

        std::istringstream iss(input);

        iss >> value;

        return true;
    }
};


#endif //!PARSER_H
