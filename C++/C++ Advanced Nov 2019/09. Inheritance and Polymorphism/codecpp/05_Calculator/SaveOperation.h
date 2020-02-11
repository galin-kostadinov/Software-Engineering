#ifndef SAVE_OPERATION_H
#define SAVE_OPERATION_H

#include <stack>
#include <exception>

class SaveOperation : public Operation {
    std::stack<int> memory;
    int result;
public:
    void addOperand(int operand) {
        memory.push(operand);
    }

    int getResult() {
        if (memory.empty()) {
            throw std::out_of_range("Empty stack");
        }

        this->result = memory.top();
        memory.pop();

        return result;
    }

    bool isCompleted() {
        return false;
    }
};

#endif //!SAVE_OPERATION_H
