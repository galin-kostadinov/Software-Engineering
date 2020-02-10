#ifndef PASTE_COMMAND_H
#define PASTE_COMMAND_H

#include <string>
#include <memory>
#include "TextTransform.h"

class PasteCommand : public TextTransform {
private:
    std::shared_ptr<CutCommand> clipboard;
public:
    PasteCommand(std::shared_ptr<CutCommand> &clipboard) : clipboard(clipboard) {}

    virtual void invokeOn(std::string &text, int startIndex, int endIndex) {
        text.replace(startIndex, endIndex - startIndex, clipboard->getLastCut());
    }
};

#endif //!PASTE_COMMAND_H
