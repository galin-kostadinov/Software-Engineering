#include <vector>
#include <string>
#include "Defines.h"
#include <sstream>
#include <iostream>

ErrorCode executeCommand(const std::string &command, std::vector<int *> &memory) {
    std::istringstream iss(command);

    size_t index = 0;
    std::string commandType;
    iss >> commandType;
    iss >> index;

    if (commandType == "Allocate") {
        if (index >= memory.size()) {
            return ErrorCode::INDEX_OUT_OF_BOUND;
        }

        if (memory[index] != nullptr) {
            return ErrorCode::MEMORY_LEAK;
        }

        memory[index] = new int;
        return ErrorCode::EXECUTE_SUCCESS;
    } else if (commandType == "Deallocate") {
        if (index >= memory.size()) {
            return ErrorCode::INDEX_OUT_OF_BOUND;
        }

        if (memory[index] == nullptr) {
            return ErrorCode::DOUBLE_FREE;
        }

        delete memory[index];
        memory[index] = nullptr;

        return ErrorCode::EXECUTE_SUCCESS;
    }

    return ErrorCode::EXECUTE_IDLE;
}

void printResult(const ErrorCode errorCode, const std::string &command) {
    std::cout << command;

    switch (errorCode) {
        case EXECUTE_SUCCESS:
            std::cout << " - success" << std::endl;
            break;
        case EXECUTE_IDLE:
            std::cout << " - this exam is a piece of cake! Where is the OOP already?!?";
            break;
        case MEMORY_LEAK :
            std::cout << " - memory leak prevented, will not make allocation";
            break;
        case DOUBLE_FREE :
            std::cout << " - system crash prevented, will skip this deallocation";
            break;
        case INDEX_OUT_OF_BOUND :
            std::cout << " - out of bound";
            break;
        default:
            break;
    }

    std::cout << std::endl;
}
