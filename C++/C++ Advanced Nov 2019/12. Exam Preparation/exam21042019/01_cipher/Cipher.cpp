#include <iostream>
#include <string>
#include "Defines.h"

ErrorCode decryptMessage(const std::string &commands,
                         const char *leftBufferData,
                         const size_t leftBufferSize,
                         const char *rightBufferData,
                         const size_t rightBufferSize,
                         std::string &outMessage) {

    if (commands.empty()) {
        return ErrorCode::DECRYPT_EMPTY;
    }

    char command = ' ';
    size_t index = 0;
    const size_t size = commands.size();

    for (size_t i = 0; i < size; i += 2) {
        command = commands[i];
        index = commands[i + 1] - '0';

        if (command == 'l') {
            if (index < 0 || index >= leftBufferSize) {
                return ErrorCode::DECRYPT_FAILURE;
            }

            outMessage.push_back(*(leftBufferData + index));
        } else if (command == 'r') {
            if (index < 0 || index >= rightBufferSize) {
                return ErrorCode::DECRYPT_FAILURE;
            }

            outMessage.push_back(*(rightBufferData + index));
        }
    }

    return ErrorCode::DECRYPT_SUCCESS;
}

void printResult(const ErrorCode errorCode,
                 const std::string &decryptedMessage) {

    std::cout << decryptedMessage;

    switch (errorCode) {
        case DECRYPT_FAILURE:
            std::cout << " Warning, buffer out-of-bound detected" << std::endl;
            break;
        case DECRYPT_EMPTY:
            std::cout << "No input provided" << std::endl;
            break;
        default:
            break;
    }
}
