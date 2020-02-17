#ifndef HASINFO_H
#define HASINFO_H

class HasInfo {
public:
    virtual std::string getInfo() const = 0;

    virtual ~HasInfo() {}
};

#endif //!HASINFO_H
