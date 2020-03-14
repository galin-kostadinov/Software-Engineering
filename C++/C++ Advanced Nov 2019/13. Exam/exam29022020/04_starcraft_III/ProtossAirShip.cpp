#include "ProtossAirShip.h"

ProtossAirShip::ProtossAirShip(const AirShipType type,
                               const int health,
                               const int damage,
                               const int maxShield,
                               const int shieldRegenerateRate,
                               const int shipId) : AirShip(type, health, damage, shipId),
                                                   _maxShield(maxShield),
                                                   _currShield(maxShield),
                                                   _shieldRegenerateRate(shieldRegenerateRate) {}


void ProtossAirShip::takeDamage(const int damage) {
    if (_currShield >= damage) {
        _currShield -= damage;
    } else {
        int rest = damage - _currShield;
        _currShield = 0;
        _currHealth -= rest;
    }
}

void ProtossAirShip::finishTurn() {
    if (isAlive()) {
        _currShield += _shieldRegenerateRate;
        if (_currShield > _maxShield) {
            _currShield = _maxShield;
        }
    }
}