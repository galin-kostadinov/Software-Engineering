#ifndef CODECPP_LECTURE_H
#define CODECPP_LECTURE_H

#include <vector>
#include <set>
#include <map>
#include "Resource.h"
#include "ResourceType.h"

namespace SoftUni {
    class Lecture {
        std::set<Resource> resources;
        std::map<ResourceType, int> numbOfResourcesByType;
    public:
        Lecture() {}

        std::set<Resource>::iterator begin() const {
            return resources.begin();
        }

        std::set<Resource>::iterator end() const {
            return resources.end();
        }

        int operator[](const ResourceType &type) const {
            auto currElement = numbOfResourcesByType.find(type);

            if (currElement != numbOfResourcesByType.end()) {
                return currElement->second;
            } else {
                return 0;
            }
        }

        friend Lecture &operator<<(Lecture &lecture, const Resource &r);

        friend std::vector<ResourceType> &operator<<(std::vector<ResourceType> &resourceTypes, const Lecture &lecture);
    };

    Lecture &operator<<(Lecture &lecture, const Resource &r) {
        std::set<Resource> *resources = &lecture.resources;
        std::map<ResourceType, int> *numbOfResourcesByType = &lecture.numbOfResourcesByType;

        if (resources->find(r) != resources->end()) {
            (*numbOfResourcesByType)[r.getType()]--;
            resources->erase(r);
        }

        resources->emplace(r);

        (*numbOfResourcesByType)[r.getType()]++;

        return lecture;
    }

    std::vector<ResourceType> &operator<<(std::vector<ResourceType> &resourceTypes, const Lecture &lecture) {
        const std::map<ResourceType, int> *numbOfResourcesByType = &lecture.numbOfResourcesByType;

        if (numbOfResourcesByType->find(ResourceType::PRESENTATION) != numbOfResourcesByType->end()) {
            resourceTypes.emplace_back(ResourceType::PRESENTATION);
        }

        if (numbOfResourcesByType->find(ResourceType::DEMO) != numbOfResourcesByType->end()) {
            resourceTypes.emplace_back(ResourceType::DEMO);
        }

        if (numbOfResourcesByType->find(ResourceType::VIDEO) != numbOfResourcesByType->end()) {
            resourceTypes.emplace_back(ResourceType::VIDEO);
        }

        return resourceTypes;
    }
}
#endif //!CODECPP_LECTURE_H
