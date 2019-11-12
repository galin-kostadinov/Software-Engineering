#include <iostream>
#include <vector>
#include <set>

using namespace std;

struct Coordinates {
    int positionX;
    int positionY;

    Coordinates(int positionX, int positionY) : positionX(positionX), positionY(positionY) {
    }
};

struct Speed {
    int speedX;
    int speedY;

    Speed(int speedX, int speedY) : speedX(speedX), speedY(speedY) {
    }
};

class Particle {
    Coordinates coordinates;
    Speed speed;
    int lifetime;

public:
    Particle(int positionX, int positionY, int speedX, int speedY, int lifetime) :
            coordinates(positionX, positionY), speed(speedX, speedY), lifetime(lifetime) {}

    Coordinates getCoordinates() {
        return this->coordinates;
    }

    void calculateNewCoordinates() {
        this->coordinates.positionX += this->speed.speedX;
        this->coordinates.positionY += this->speed.speedY;
    }

    int getLifetime() const {
        return lifetime;
    }

    const int reduceLifeTime() {
        this->lifetime--;
        return lifetime;
    }

    bool isAlive() {
        return this->lifetime > 0;
    }
};

bool checkForCollision(const Coordinates &a, const Coordinates &b) {
    return a.positionX == b.positionX && a.positionY == b.positionY;
}

void readInput(vector<Particle> &antimatter, vector<Particle> &matter, const int numberOfParticles) {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    char type = 0;
    int positionX = 0;
    int positionY = 0;
    int speedX = 0;
    int speedY = 0;
    int lifetime = 0;

    for (int i = 0; i < numberOfParticles; ++i) {
        cin >> type >> positionX >> positionY >> speedX >> speedY >> lifetime;

        if (type == 'a') {
            antimatter.emplace_back(Particle(positionX, positionY, speedX, speedY, lifetime));
        } else {
            matter.emplace_back(Particle(positionX, positionY, speedX, speedY, lifetime));
        }
    }
}

bool checkIsInBound(Coordinates coordinates) {
    return (coordinates.positionX >= 0 && coordinates.positionX <= 65535) &&
           (coordinates.positionY >= 0 && coordinates.positionY <= 65535);
}

void updatePosition(vector<Particle> &particles) {
    int size = (int) particles.size();

    for (int j = 0; j < size;) {
        particles[j].calculateNewCoordinates();

        if (!checkIsInBound(particles[j].getCoordinates())) {
            particles.erase(particles.begin() + j);
            size--;
            continue;
        }

        if (particles[j].reduceLifeTime()) {
            ++j;
        } else {
            particles.erase(particles.begin() + j);
            size--;
        }
    }
}

void removeElements(vector<Particle> &matter, set<int> &matterIndexesToRemove) {
    set<int>::reverse_iterator it = matterIndexesToRemove.rbegin();

    while (it != matterIndexesToRemove.rend()) {
        matter.erase(matter.begin() + (*it));
        it++;
    }
}

void updateDestroyedElements(vector<Particle> &matter, vector<Particle> &antimatter) {
    set<int> matterIndexesToRemove;
    set<int> antimatterIndexesToRemove;

    int matterSize = (int) matter.size();
    int antimatterSize = (int) antimatter.size();

    for (int i = 0; i < matterSize; ++i) {
        for (int j = 0; j < antimatterSize; ++j) {
            if (checkForCollision(matter[i].getCoordinates(), antimatter[j].getCoordinates())) {
                matterIndexesToRemove.emplace(i);
                antimatterIndexesToRemove.emplace(j);
            }
        }
    }

    removeElements(matter, matterIndexesToRemove);
    removeElements(antimatter, antimatterIndexesToRemove);
}

int main() {
    std::cin.sync_with_stdio(false);
    std::cout.sync_with_stdio(false);

    int numberOfParticles;
    cin >> numberOfParticles;

    vector<Particle> antimatter;
    vector<Particle> matter;

    readInput(antimatter, matter, numberOfParticles);

    int time = 0;
    cin >> time;

    int count = 0;
    for (int i = 0; i < time; ++i) {
        updatePosition(antimatter);
        updatePosition(matter);

        size_t oldSizeAntimatter = antimatter.size();
        if (oldSizeAntimatter == 0) {
            continue;
        }

        size_t oldSizeMatter = matter.size();
        if (oldSizeMatter == 0) {
            continue;
        }

        updateDestroyedElements(matter, antimatter);

        size_t newSizeAntimatter = antimatter.size();
        size_t newSizeMatter = matter.size();

        count += oldSizeAntimatter - newSizeAntimatter + oldSizeMatter - newSizeMatter;

        if (newSizeAntimatter == 0 && newSizeMatter == 0) {
            break;
        }

    }

    std::cout << matter.size() << ' ' << antimatter.size() << std::endl;
    std::cout << count << std::endl;

    return 0;
}