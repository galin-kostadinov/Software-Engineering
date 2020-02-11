#ifndef EXTENDED_INPUT_INTERPRETER_H
#define EXTENDED_INPUT_INTERPRETER_H

#include "InputInterpreter.h"
#include "DivisionOperation.h"
#include "SaveOperation.h"
#include "MemoryRecallOperation.h"

class ExtendedInputInterpreter : public InputInterpreter {
    std::shared_ptr<SaveOperation> memory;
public:
    ExtendedInputInterpreter(CalculationEngine &engine) : InputInterpreter(engine),
                                                          memory(std::make_shared<SaveOperation>()) {}

    virtual std::shared_ptr<Operation> getOperation(std::string operation) override {
        std::shared_ptr<Operation> currOperation = InputInterpreter::getOperation(operation);

        if (operation == "/") {
            currOperation = std::make_shared<DivisionOperation>();
        } else if (operation == "ms") {
            currOperation = this->memory;
        } else if (operation == "mr") {
            currOperation = std::make_shared<MemoryRecallOperation>(this->memory);
        }

        return currOperation;
    }

};

#endif //!EXTENDED_INPUT_INTERPRETER_H
