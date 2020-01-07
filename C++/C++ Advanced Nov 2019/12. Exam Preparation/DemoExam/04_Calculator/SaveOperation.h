#ifndef SAVE_OPERATION_H
#define SAVE_OPERATION_H

#include <stack>
#include <exception>
#include "Operation.h"

class SaveOperation : public Operation {
    std::stack<int> operands;
public:
    void addOperand(int operand) override {
        this->operands.push(operand);
    }

    bool isCompleted() override {
        return false;
    }

    int getResult() override {
        if (operands.empty()) {
            throw std::out_of_range("Empty stack");
        }

        int result = operands.top();
        operands.pop();

        return result;
    }
};

#endif //!SAVE_OPERATION_H
