#include <iostream>
#include <vector>
#include <algorithm>

struct Activity {
    int startTime;
    int endTime;

    Activity(int startTime, int endTime) {
        this->startTime = startTime;
        this->endTime = endTime;
    }
};

bool sortByEndTimeAsc(const Activity &a, const Activity &b) {
    return a.endTime < b.endTime;
}

void printActivity(const Activity &activity) {
    std::cout << activity.startTime << " - " << activity.endTime << std::endl;
}

int main() {
    std::vector<int> startingTimes{1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
    std::vector<int> endingTimes{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    std::vector<Activity> activities;

    for (size_t i = 0; i < startingTimes.size(); ++i) {
        activities.emplace_back(startingTimes[i], endingTimes[i]);
    }

    std::sort(activities.begin(), activities.end(), sortByEndTimeAsc);

    Activity last = activities[0];
    printActivity(last);

    for (size_t j = 1; j < activities.size(); ++j) {
        Activity currActivity = activities[j];
        if (currActivity.startTime >= last.endTime) {
            last = activities[j];
            printActivity(last);
        }
    }

    return 0;
}