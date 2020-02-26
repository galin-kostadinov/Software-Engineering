#include <stack>
#include <iostream>
#include "ContainerInterface.h"
#include "Defines.h"
#include "MemoryContainer.h"

void printInfo(const size_t &occupiedMemory) {
    std::cout << "occupiedMemory: " << occupiedMemory << std::endl;
}

void pushContainer(const ContainerType containerType,
                   const size_t containerSize,
                   std::stack<ContainerInterface *> &containers,
                   size_t &occupiedMemory) {

    switch (containerType) {
        case SHORT_CONTAINER :
            containers.push(new MemoryContainer<short>(containerSize));
            break;
        case INT_CONTAINER:
            containers.push(new MemoryContainer<int>(containerSize));
            break;
        case LONG_LONG_CONTAINER:
            containers.push(new MemoryContainer<long long>(containerSize));
            break;
        default:
            break;
    }

    occupiedMemory += containers.top()->getOccupiedMemory();
    printInfo(occupiedMemory);
}

void popContainer(std::stack<ContainerInterface *> &containers,
                  size_t &occupiedMemory) {

    if (!containers.empty()) {
        ContainerInterface *ptr = containers.top();

        occupiedMemory -= ptr->getOccupiedMemory();
        containers.pop();

        delete ptr;
    }

    printInfo(occupiedMemory);
}

//void freeMemory(std::stack<ContainerInterface *> &containers) {}