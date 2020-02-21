#ifndef CUT_COMMAND_H
#define CUT_COMMAND_H

#include "TextTransform.h"
#include <string>

class CutCommand : public TextTransform {
protected:
    std::string clipboard;
public:
    virtual void invokeOn(std::string &text, int startIndex, int endIndex) override {
        this->clipboard = text.substr(startIndex, endIndex - startIndex);
        text.erase(startIndex, endIndex - startIndex);
    }

    std::string getClipboard() const {
        return this->clipboard;
    }
};

#endif //!CUT_COMMAND_H
