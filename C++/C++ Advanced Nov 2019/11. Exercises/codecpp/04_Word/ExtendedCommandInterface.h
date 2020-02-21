#ifndef EXTENDED_COMMAND_INTERFACE_H
#define EXTENDED_COMMAND_INTERFACE_H

#include <cstdlib>
#include <memory>
#include "CommandInterface.h"
#include "CutCommand.h"
#include "PasteCommand.h"

class ExtendedCommandInterface : public CommandInterface {

public:
    ExtendedCommandInterface(std::string &text) : CommandInterface{text} {}

protected:
    virtual std::vector<Command> initCommands() override {
        std::vector<Command> commands = CommandInterface::initCommands();

        std::shared_ptr<CutCommand> cutCommand = std::make_shared<CutCommand>();
        commands.emplace_back("cut", cutCommand);

        commands.emplace_back("paste", std::make_shared<PasteCommand>(cutCommand));

        return commands;
    }
};

#endif //!EXTENDED_COMMAND_INTERFACE_H
