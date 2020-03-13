#include "Viking.h"
#include <iostream>

Viking::Viking(const AirShipType type,
               const int health,
               const int baseDamage,
               const int shipId) : TerranAirShip(type, health, baseDamage, shipId) {

}

void Viking::dealDamage(std::vector<std::unique_ptr<AirShip>> &enemyFleet) {
    _passedTurns++;
    if (enemyFleet.back()->getAirShipType() == AirShipType::PHOENIX) {
        enemyFleet.back()->takeDamage(_damage * 2);
    } else {
        enemyFleet.back()->takeDamage(_damage);
    }

    if (!enemyFleet.back()->isAlive()) {
        std::cout << "Viking with ID: " << this->getAirShipId() << " killed enemy airship with ID: "
                  << enemyFleet.back()->getAirShipId() << std::endl;
        enemyFleet.pop_back();
    }
}