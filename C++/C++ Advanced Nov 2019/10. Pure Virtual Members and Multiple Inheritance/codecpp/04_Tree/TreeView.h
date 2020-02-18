#ifndef TREEVIEW_H
#define TREEVIEW_H

#include <string>
#include <memory>
#include <vector>

#include "FileSystemObject.h"
#include "FileSystemObjectsContainer.h"
#include <ostream>
#include <string>
#include <vector>
#include <memory>

void printWithIndentation(std::ostringstream &oss,
                          const std::shared_ptr<FileSystemObject> &root,
                          const std::string &indentation,
                          const int n) {

    auto currObjectCast = std::dynamic_pointer_cast<FileSystemObjectsContainer>(root);

    if (currObjectCast == nullptr) {
        return;
    }

    std::vector<std::shared_ptr<FileSystemObject> > rootObjects(currObjectCast->begin(), currObjectCast->end());

    std::sort(rootObjects.begin(), rootObjects.end(),
              [](const std::shared_ptr<FileSystemObject> a, const std::shared_ptr<FileSystemObject> b) {
                  return a->getName() < b->getName();
              });


    for (const std::shared_ptr<FileSystemObject> &curr:rootObjects) {
        for (int i = 0; i < n; ++i) {
            oss << indentation;
        }

        oss << curr->getName() << std::endl;

        printWithIndentation(oss, curr, indentation, n + 1);
    }
}

std::string getTreeView(const std::vector<std::shared_ptr<FileSystemObject> > &rootObjects) {
    std::ostringstream oss;

    for (const std::shared_ptr<FileSystemObject> &root:rootObjects) {
        oss << root->getName() << std::endl;

        std::string indentation = "--->";
        printWithIndentation(oss, root, indentation, 1);
    }

    return oss.str();
}

#endif //!TREEVIEW_H
