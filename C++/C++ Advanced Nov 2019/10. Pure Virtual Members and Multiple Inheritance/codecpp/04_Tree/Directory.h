#ifndef DIRECTORY_H
#define DIRECTORY_H

#include <vector>
#include <memory>
#include <string>
#include "FileSystemObjectsContainer.h"
#include "FileSystemObject.h"

class Directory : public FileSystemObjectsContainer, public FileSystemObject {
    std::vector<std::shared_ptr<FileSystemObject>> files;
public:
    Directory(const std::string &directory) : FileSystemObject(directory) {}

    void add(const std::shared_ptr<FileSystemObject> &obj) override {
        files.push_back(obj);
    }

    std::vector<std::shared_ptr<FileSystemObject>> getFiles() const {
        return this->files;
    }

    size_t getSize() const override {
        size_t size = 0;

        for (const std::shared_ptr<FileSystemObject> &file:files) {
            size += file->getSize();
        }

        return size;
    }

    std::vector<std::shared_ptr<FileSystemObject> >::const_iterator begin() const override {
        return files.begin();
    }

    std::vector<std::shared_ptr<FileSystemObject> >::const_iterator end() const override {
        return files.end();
    }
};

#endif //!DIRECTORY_H
