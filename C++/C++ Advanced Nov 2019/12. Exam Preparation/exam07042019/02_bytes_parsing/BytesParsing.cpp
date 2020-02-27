#include <vector>
#include <string>
#include "Defines.h"
#include <iostream>
#include <cmath>

void parseNumber(const char *&itBytes,
                 int sizeOfBytesGroup,
                 size_t &resultNum);

ErrorCode parseData(const std::string &commands,
                    const char *rawDataBytes,
                    const size_t rawDataBytesCount,
                    std::vector<long long> &outParsedNumbers) {

    if (rawDataBytesCount == 0 || commands.empty() ||
        rawDataBytes == nullptr) {
        return ErrorCode::PARSE_EMPTY;
    }

    const char *it = rawDataBytes;
    size_t resultNum = 0;

    size_t count = 0;
    for (size_t i = 0; i < commands.size(); ++i) {
        int currentCommandSize = 0;
        resultNum = 0;
        switch (commands[i]) {
            case 's':
                currentCommandSize = 2;
                break;
            case 'i':
                currentCommandSize = 4;
                break;
            case 'l':
                currentCommandSize = 8;
                break;
            default:
                break;
        }

        if (count + currentCommandSize > rawDataBytesCount) {
            return ErrorCode::PARSE_FAILURE;
        }

        parseNumber(it, currentCommandSize, resultNum);
        outParsedNumbers.push_back(resultNum);
        count += currentCommandSize;
    }

    return ErrorCode::PARSE_SUCCESS;
}

void parseNumber(const char *&itBytes,
                 int sizeOfBytesGroup,
                 size_t &resultNum) {
    if (sizeOfBytesGroup != 2 && sizeOfBytesGroup != 4 && sizeOfBytesGroup != 8) {
        return;
    }

    for (size_t i = 0; i < sizeOfBytesGroup; ++i) {
        resultNum += (size_t) (std::pow(2, i * 8)) * (*itBytes);
        itBytes++;
    }
}

void printResult(const ErrorCode errorCode,
                 const std::vector<long long> &parsedNumbers) {

    for (const long long int num:parsedNumbers) {
        std::cout << num << ' ';
    }

    if (errorCode == ErrorCode::PARSE_EMPTY) {
        std::cout << "No input provided" << std::endl;
    } else if (errorCode == ErrorCode::PARSE_FAILURE) {
        std::cout << "Warning, buffer underflow detected" << std::endl;
    } else {
        std::cout << std::endl;
    }
}