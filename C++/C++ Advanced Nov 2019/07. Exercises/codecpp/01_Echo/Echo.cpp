#include "Echo.h"

bool echoOn = false;

void echo(const std::string &str) {
    if (echoOn) {
        std::cout << str << std::endl;
    }
}