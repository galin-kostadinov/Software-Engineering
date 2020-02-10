#ifndef CUT_COMMAND_H
#define CUT_COMMAND_H

#include <string>
#include "TextTransform.h"

class CutCommand : public TextTransform {
private:
    std::string lastCut;
public:
    virtual void invokeOn(std::string &text, int startIndex, int endIndex) {
        this->lastCut = text.substr(startIndex, endIndex - startIndex);
        text.erase(startIndex, endIndex - startIndex);
    }

    std::string getLastCut() const {
        return this->lastCut;
    }
};

#endif //!CUT_COMMAND_H
