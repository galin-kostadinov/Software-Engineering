#ifndef INITIALIZATION_H
#define INITIALIZATION_H

#include <memory>
#include "ExtendedCommandInterface.h"

std::shared_ptr<CommandInterface> buildCommandInterface(std::string &text) {
    std::shared_ptr<CommandInterface> extendedCommand = std::make_shared<ExtendedCommandInterface>(text);
    extendedCommand->init();

    return extendedCommand;
}

#endif //!INITIALIZATION_H
