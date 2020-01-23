#ifndef SOLFEGENOTENAMING_H
#define SOLFEGENOTENAMING_H

#include<unordered_map>
#include "NoteName.h"

struct SolfegeNoteNaming {
    std::unordered_map<std::string, NoteName> names{{"Do",  'C'},
                                          {"Re",  'D'},
                                          {"Mi",  'E'},
                                          {"Fa",  'F'},
                                          {"Sol", 'G'},
                                          {"La",  'A'},
                                          {"Si",  'B'}};

    NoteName operator()(const std::string &noteText) const {
        const std::unordered_map<std::string, NoteName>::const_iterator it = names.find(noteText);

        if (it != names.end()) {
            return (*it).second;
        }

        return NoteName{'?'};
    }
};

#endif //!SOLFEGENOTENAMING_H
