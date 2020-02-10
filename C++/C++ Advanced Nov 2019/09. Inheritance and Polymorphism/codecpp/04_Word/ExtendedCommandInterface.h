#ifndef EXTENDED_COMMANDINTERFACE_H
#define EXTENDED_COMMANDINTERFACE_H

#include <string>
#include <memory>
#include "CommandInterface.h"
#include "CutCommand.h"
#include "PasteCommand.h"

class ExtendedCommandInterface : public CommandInterface {
public:
    ExtendedCommandInterface(std::string &text) : CommandInterface(text) {}

protected:
    virtual std::vector<Command> initCommands() override {
        std::vector<Command> commands = CommandInterface::initCommands();

        std::shared_ptr<CutCommand> clipboard = std::make_shared<CutCommand>();

        commands.push_back(Command("cut", clipboard));
        commands.push_back(Command("paste", std::make_shared<PasteCommand>(clipboard)));

        return commands;
    }
};

#endif //!EXTENDED_COMMANDINTERFACE_H
