#include <iostream>
#include <map>
#include <string>
#include <utility>
#include <queue>

int orderIndex = 0;

struct compare {
    bool operator()(std::tuple<int, int, std::string> &a, std::tuple<int, int, std::string> &b) {
        if (std::get<0>(a) == std::get<0>(b)) {
            return std::get<1>(a) > std::get<1>(b);
        }

        return std::get<0>(a) < std::get<0>(b);
    }
};

typedef std::priority_queue<std::tuple<int, int, std::string>, std::vector<std::tuple<int, int, std::string>>, compare> pq;

class Message {
    std::string roughMessage;
    std::string message;
    int priority;
    int order;
    bool isReady;
    bool isPrinted;


public:
    explicit Message(std::string &roughMessage) : roughMessage(roughMessage) {
        this->priority = -1;
        this->isReady = false;
        this->isPrinted = false;
        this->order = orderIndex++;
        if (this->checkIsReady()) {
            this->setPriorityAndMassage();
        }
    }

    void combineMessages(std::string &message) {
        if (isReady) {
            return;
        }

        int size = (int) this->roughMessage.size();

        for (int i = 0; i < size; ++i) {
            if (this->roughMessage[i] == '?' && message[i] != '?') {
                this->roughMessage[i] = message[i];
            }
        }

        if (checkIsReady()) {
            this->setPriorityAndMassage();
        }
    }

    bool getIsPrinted() const {
        return isPrinted;
    }

    int getOrder() const {
        return order;
    }

    void setIsPrinted(bool isPrinted) {
        Message::isPrinted = isPrinted;
    }

    bool getIsReady() const {
        return isReady;
    }

    const std::string &getMessage() const {
        return message;
    }

    int getPriority() const {
        return priority;
    }

private:
    void setPriorityAndMassage() {
        std::string priorityAsString;
        int size = (int) this->roughMessage.size();

        for (int i = 0; i < size; ++i) {
            if (isdigit(this->roughMessage[i])) {
                priorityAsString.push_back(this->roughMessage[i]);
            } else {
                message.push_back(this->roughMessage[i]);
            }
        }

        this->priority = stoi(priorityAsString);
        this->isReady = true;
    }

    bool checkIsReady() {
        int size = (int) this->roughMessage.size();

        for (int i = 0; i < size; ++i) {
            if (this->roughMessage[i] == '?') {
                return false;
            }
        }

        return true;
    }
};

void readMessage(std::map<std::string, Message> &messages, const std::string &line, pq &readyMessage) {
    std::string frequency;
    std::string message;

    int indexOfSpace = line.find(' ');
    frequency = line.substr(0, indexOfSpace);
    message = line.substr(indexOfSpace + 1);

    const std::map<std::string, Message>::iterator &it = messages.find(frequency);

    if (messages.find(frequency) == messages.end()) {
        messages.insert(std::pair<std::string, Message>(frequency, Message(message)));
    } else {
        it->second.combineMessages(message);
    }

    const std::map<std::string, Message>::iterator &newIt = messages.find(frequency);

    if (newIt->second.getIsReady() && !(newIt->second.getIsPrinted())) {
        readyMessage.push(
                make_tuple(newIt->second.getPriority(), newIt->second.getOrder(), newIt->second.getMessage()));
        newIt->second.setIsPrinted(true);
    }
}

void printMessage(pq &readyMessage) {
    if (readyMessage.empty()) {
        std::cout << "[no new messages]" << std::endl;
    } else {
        std::cout << std::get<2>(readyMessage.top()) << std::endl;
        readyMessage.pop();
    }

}

int main() {
    std::map<std::string, Message> messages;
    pq readyMessage;

    std::string line;

    while (getline(std::cin, line) && line != "end") {
        if (line == "report") {
            printMessage(readyMessage);
        } else {
            readMessage(messages, line, readyMessage);
        }
    }

    return 0;
}