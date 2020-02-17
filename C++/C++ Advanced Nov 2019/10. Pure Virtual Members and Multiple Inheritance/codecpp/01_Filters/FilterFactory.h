#ifndef FILTERFACTORY_H
#define FILTERFACTORY_H

#include "Filter.h"
#include "string"
#include "cctype"

class RemovesCapitalLetters : public Filter {
protected:
    bool shouldFilterOut(char symbol) const override {
        return std::isupper(symbol);
    }
};

class RemovesNonCapitalLetters : public Filter {
protected:
    bool shouldFilterOut(char symbol) const override {
        return std::islower(symbol);
    }
};

class RemovesDigits : public Filter {
protected:
    bool shouldFilterOut(char symbol) const override {
        return std::isdigit(symbol);
    }
};

class FilterFactory {
public:
    Filter *buildFilter(std::string &filterDefinition) const {
        if (filterDefinition == "A-Z") {
            return new RemovesCapitalLetters();
        } else if (filterDefinition == "a-z") {
            return new RemovesNonCapitalLetters();
        } else if (filterDefinition == "0-9") {
            return new RemovesDigits();
        } else {
            return nullptr;
        }
    }
};

#endif //!FILTERFACTORY_H
