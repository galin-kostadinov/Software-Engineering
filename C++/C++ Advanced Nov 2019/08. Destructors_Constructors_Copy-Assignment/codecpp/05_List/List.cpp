#include "List.h"
#include <sstream>
#include <stdexcept>

//Implement Node

List::Node::Node(int value, Node *prev, Node *next) : value(value), prev(prev), next(next) {}

int List::Node::getValue() const {
    return this->value;
}

void List::Node::setValue(int value) {
    this->value = value;
}

List::Node *List::Node::getNext() const {
    return this->next;
}

void List::Node::setNext(Node *next) {
    this->next = next;
}

List::Node *List::Node::getPrev() const {
    return this->prev;
}

void List::Node::setPrev(Node *prev) {
    this->prev = prev;
}

//Implement List

List::List() : head(nullptr), tail(nullptr), size(0) {}

List::List(const List &other) : head(nullptr), tail(nullptr), size(0) {
    this->addAll(other);
}

int List::first() const {
    if (this->isEmpty()) {
        throw std::range_error("Empty List");
    }

    return this->head->getValue();
}

void List::add(int value) {
    Node *newNode = new Node(value, nullptr, nullptr);

    if (this->size == 0) {
        this->head = newNode;
        this->tail = newNode;
    } else {
        this->tail->setNext(newNode);
        newNode->setPrev(this->tail);
        this->tail = newNode;
    }

    this->size++;
}

void List::addAll(const List &other) {
    Node *otherCurrentNode = other.head;

    while (otherCurrentNode != nullptr) {
        this->add(otherCurrentNode->getValue());
        otherCurrentNode = otherCurrentNode->getNext();
    }
}

void List::removeFirst() {
    if (size == 1) {
        delete this->head;
        this->head = nullptr;
        this->tail = nullptr;
        this->size--;
    } else if (size > 1) {
        Node *toDelete = this->head;
        this->head = this->head->getNext();
        this->head->setPrev(nullptr);
        delete toDelete;
        this->size--;
    }
}

void List::removeAll() {
    while (!isEmpty()) {
        this->removeFirst();
    }
}

size_t List::getSize() const {
    return this->size;
}

bool List::isEmpty() const {
    return this->size == 0;
}

List List::getReversed(List l) {
    List reversedList;

    Node *currentNode = l.tail;

    while (currentNode != nullptr) {
        reversedList.add(currentNode->getValue());
        currentNode = currentNode->getPrev();
    }

    return reversedList;
}

std::string List::toString() const {
    std::ostringstream oss;
    Node *currentNode = this->head;

    bool putSpace = false;

    while (currentNode != nullptr) {
        if (putSpace) {
            oss << ' ';
        } else {
            putSpace = true;
        }

        oss << currentNode->getValue();
        currentNode = currentNode->getNext();
    }

    return oss.str();
}

List &List::operator<<(const int &value) {
    this->add(value);
    return *this;
}

List &List::operator<<(const List &other) {
    this->addAll(other);
    return *this;
}

List &List::operator=(const List &other) {
    if (this == &other) {
        return *this;
    }

    this->removeAll();
    this->addAll(other);

    return *this;
}

List::~List() {
    this->removeAll();
}