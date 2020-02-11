#ifndef MEMORY_RECALL_OPERATION_H
#define MEMORY_RECALL_OPERATION_H

class MemoryRecallOperation : public Operation {
    std::shared_ptr<SaveOperation> memory;
public:
    MemoryRecallOperation(std::shared_ptr<SaveOperation> &memory) : memory(memory) {}

    void addOperand(int operand) {}

    int getResult() {
        return memory->getResult();
    }

    bool isCompleted() {
        return true;
    }
};

#endif //!MEMORY_RECALL_OPERATION_H
