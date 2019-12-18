#ifndef CODECPP_RESOURCE_H
#define CODECPP_RESOURCE_H

#include "ResourceType.h"

namespace SoftUni {

    class Resource {
        int id;
        ResourceType type;
        std::string link;

    public:
        Resource() {}

        ResourceType getType() const {
            return this->type;
        }

        bool operator<(const Resource &other) {
            return this->id < other.id;
        }

        friend std::istream &operator>>(std::istream &iss, Resource &r);

        friend std::ostream &operator<<(std::ostream &oss, const Resource &r);

        friend bool operator<(const Resource &left, const Resource &right);
    };

    std::istream &operator>>(std::istream &iss, Resource &r) {
        std::string typeAsString;

        iss >> r.id >> typeAsString >> r.link;

        if (typeAsString == "Presentation") {
            r.type = ResourceType::PRESENTATION;
        } else if (typeAsString == "Demo") {
            r.type = ResourceType::DEMO;
        } else if (typeAsString == "Video") {
            r.type = ResourceType::VIDEO;
        }

        return iss;
    }

    std::ostream &operator<<(std::ostream &oss, const Resource &r) {
        oss << r.id << ' ' << r.type << ' ' << r.link;
        return oss;
    }

    bool operator<(const Resource &left, const Resource &right) {
        return left.id < right.id;
    }
}

#endif //!CODECPP_RESOURCE_H
