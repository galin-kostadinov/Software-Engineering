#ifndef CONTAINER_INTERFACE_H
#define CONTAINER_INTERFACE_H

#include <string>

class ContainerInterface {

public:
    ContainerInterface() = default;

    virtual size_t getOccupiedMemory() const = 0;

    virtual ~ContainerInterface() = default;
};

#endif //CONTAINER_INTERFACE_H
