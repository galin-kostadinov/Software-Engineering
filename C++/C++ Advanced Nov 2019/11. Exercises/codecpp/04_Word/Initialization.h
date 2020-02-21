#ifndef INITIALIZATION_H
#define INITIALIZATION_H

#include <memory>
#include <cstdlib>

#include "ExtendedCommandInterface.h"
#include "CommandInterface.h"

std::shared_ptr<CommandInterface> buildCommandInterface(std::string &text) {
    std::shared_ptr<CommandInterface> interface = std::make_shared<ExtendedCommandInterface>(text);
    interface->init();
    return interface;
}

#endif //!INITIALIZATION_H
