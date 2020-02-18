#ifndef FILE_H
#define FILE_H

#include "ByteContainer.h"
#include "FileSystemObject.h"

class File :public FileSystemObject, public ByteContainer  {
public:
    File(const std::string &filename, const std::string &bytes) : FileSystemObject(filename), ByteContainer(bytes) {}

    size_t getSize() const override {
        return this->bytes.size();
    }

    std::string getBytes() const override {
        return this->bytes;
    }
};

#endif //!FILE_H
