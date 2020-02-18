#ifndef EXPLORER_H
#define EXPLORER_H

#include <vector>
#include <memory>

#include "FileSystemObject.h"
#include "ByteContainer.h"
#include "File.h"
#include "FileSystemObjectsContainer.h"
#include "Directory.h"
#include "Shortcuts.h"

class Explorer {
private:
    std::vector<std::shared_ptr<FileSystemObject>> &rootObjects;
    const std::weak_ptr<Directory> rootFolder;
    std::weak_ptr<Directory> current;
    std::vector<std::shared_ptr<FileSystemObject>> clipboard;
    std::shared_ptr<Shortcuts> shortcuts;

    void addToRoot(const std::shared_ptr<FileSystemObject> &obj) {
        this->rootObjects.push_back(obj);
        obj->setParent(this->rootFolder);
    }

    void initFileSystemObject(const std::shared_ptr<FileSystemObject> &obj) {
        std::shared_ptr<Directory> currentDirectoryPtr = this->current.lock();

        if (currentDirectoryPtr != nullptr) {
            obj->setParent(currentDirectoryPtr);
            currentDirectoryPtr->add(obj);
        } else {
            this->addToRoot(obj);
        }
    }

    std::shared_ptr<FileSystemObject> getItemByNameInRoot(const std::string &objectName) const {
        auto it = find_if(this->rootObjects.cbegin(), this->rootObjects.cend(),
                          [&objectName](const std::shared_ptr<FileSystemObject> &obj) {
                              return obj->getName() == objectName;
                          });

        return (it != this->rootObjects.cend()) ? *it : nullptr;
    }

    std::shared_ptr<FileSystemObject> getItemByNameInCurrentDirectory(const std::string &objectName) const {
        std::shared_ptr<Directory> currentDirectoryPtr = this->current.lock();

        if (currentDirectoryPtr != nullptr) {
            return currentDirectoryPtr->getItemByName(objectName);
        }

        return this->getItemByNameInRoot(objectName);
    }

public:
    explicit Explorer(std::vector<std::shared_ptr<FileSystemObject>> &rootObjects) : rootObjects(rootObjects) {}

    void createFile(const std::string &filename, const std::string &contents) {
        this->initFileSystemObject(std::make_shared<File>(filename, contents));
    }

    void createDirectory(const std::string &directory) {
        this->initFileSystemObject(std::make_shared<Directory>(directory));
    }

    void cut(const std::string &name) {
        std::shared_ptr<FileSystemObject> obj = this->getItemByNameInCurrentDirectory(name);

        if (obj != nullptr) {
            this->clipboard.push_back(obj);
        }
    }

    void paste() {
        for (const auto &item : this->clipboard) {
            if (item->getParent().expired()) {
                this->rootObjects.erase(std::find(this->rootObjects.begin(), this->rootObjects.end(), item));
            } else {
                std::static_pointer_cast<Directory>(item->getParent().lock())->remove(item);
            }
            this->initFileSystemObject(item);
        }
        this->clipboard.clear();
    }

    void createShortcut(const std::string &name) {
        std::shared_ptr<FileSystemObject> item = this->getItemByNameInCurrentDirectory(name);

        if (item != nullptr) {
            if (!this->shortcuts) {
                this->shortcuts = std::make_shared<Shortcuts>();
                this->addToRoot(this->shortcuts);
            }
            this->shortcuts->add(item);
        }
    }

    void navigate(const std::string &path) {
        if (path == "..") {
            if (!this->current.expired()) {
                this->current = std::static_pointer_cast<Directory>(this->current.lock()->getParent().lock());
            }
            return;
        }

        std::shared_ptr<FileSystemObject> newObject = this->getItemByNameInCurrentDirectory(path);

        if (newObject != nullptr) {
            std::shared_ptr<Directory> newDirectory = std::dynamic_pointer_cast<Directory>(newObject);
            if (newDirectory != nullptr) {
                this->current = newDirectory;
            }
        }
    }
};

#endif //!EXPLORER_H
