#include "Carrier.h"
#include <iostream>

Carrier::Carrier(const AirShipType type,
                 const int health,
                 const int damage,
                 const int maxShield,
                 const int shieldRegenerateRate,
                 const int shipId) : ProtossAirShip(type, health, damage, maxShield, shieldRegenerateRate, shipId),
                                     _activeInterceptors(MAX_INTERCEPTORS) {

}

void Carrier::takeDamage(const int damage) {
    ProtossAirShip::takeDamage(damage);

    if (_currHealth < _maxHealth) {
        _activeInterceptors = DAMAGED_STATUS_INTERCEPTORS;
    }
}

void Carrier::dealDamage(std::vector<std::unique_ptr<AirShip>> &enemyFleet) {
    for (int i = 0; i < _activeInterceptors && !enemyFleet.empty(); ++i) {
        enemyFleet.back()->takeDamage(_damage);
        if (!enemyFleet.back()->isAlive()) {
            std::cout << "Carrier with ID: " << this->getAirShipId() << " killed enemy airship with ID: "
                      << enemyFleet.back()->getAirShipId() << std::endl;
            enemyFleet.pop_back();
        }
    }
}