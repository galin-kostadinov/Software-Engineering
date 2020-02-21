#ifndef PASTE_COMMAND_H
#define PASTE_COMMAND_H

#include <memory>
#include "TextTransform.h"

class PasteCommand : public TextTransform {
private:
    std::shared_ptr<CutCommand> cutCommand;
public:
    PasteCommand(std::shared_ptr<CutCommand> &cutCommand) : cutCommand(cutCommand) {}

    virtual void invokeOn(std::string &text, int startIndex, int endIndex) override {
        text.replace(startIndex, endIndex - startIndex, cutCommand->getClipboard());
    }
};

#endif //!PASTE_COMMAND_H
