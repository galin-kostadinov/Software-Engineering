#ifndef MEMORY_RECALL_OPERATION_H
#define MEMORY_RECALL_OPERATION_H

#include <memory>

#include "Operation.h"
#include "SaveOperation.h"

class MemoryRecallOperation : public Operation {
    std::shared_ptr<SaveOperation> memory;
public:
    MemoryRecallOperation(std::shared_ptr<SaveOperation> &memory) : memory(memory) {}

    void addOperand(int operand) override {
    }

    bool isCompleted() override {
        return true;
    }

    int getResult() override {
        return memory->getResult();
    }
};

#endif //!MEMORY_RECALL_OPERATION_H
