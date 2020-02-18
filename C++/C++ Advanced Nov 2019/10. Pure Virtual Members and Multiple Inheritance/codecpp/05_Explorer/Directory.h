#ifndef DIRECTORY_H
#define DIRECTORY_H

#include <vector>
#include <algorithm>
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

    size_t getSize() const override {
        size_t size = 0;

        for (const std::shared_ptr<FileSystemObject> &file:files) {
            size += file->getSize();
        }

        return size;
    }

    std::shared_ptr<FileSystemObject> getItemByName(const std::string& name) {
        auto nameMatches = [&name](const std::shared_ptr<FileSystemObject>& obj) { return obj->getName() == name; };
        auto it = std::find_if(this->files.cbegin(), this->files.cend(), nameMatches);
        return (it != this->files.cend()) ? *it : nullptr;
    }

    void remove(std::shared_ptr<FileSystemObject> obj) override {
        this->files.erase(std::find(this->files.begin(), this->files.end(), obj));
    }

    std::vector<std::shared_ptr<FileSystemObject> >::const_iterator begin() const override {
        return files.begin();
    }

    std::vector<std::shared_ptr<FileSystemObject> >::const_iterator end() const override {
        return files.end();
    }
};

#endif //!DIRECTORY_H
