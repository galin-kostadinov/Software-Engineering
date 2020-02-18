#ifndef BYTECONTAINER_H
#define BYTECONTAINER_H

#include <string>

class ByteContainer {
protected:
    std::string bytes;
public:
    ByteContainer(const std::string &bytes) : bytes(bytes) {}

    virtual std::string getBytes() const = 0;

    virtual ~ByteContainer() {}
};

#endif //!BYTECONTAINER_H
