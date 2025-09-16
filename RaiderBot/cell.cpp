/*
 * cell.cpp
 *
 *      Author: Kaiden Pollesch
 */

#include "cell.h"

MapCell::MapCell(int x, int y, char type) : xLocation(x), yLocation(y), token(type), hasRobot(false) {}

bool MapCell::hasPit() {
    return token == '#';
}

bool MapCell::hasThief() {
    return token == 'T';
}

bool MapCell::hasGold() {
    return token == '*';
}

void MapCell::removeGold() {
    if (hasGold()) {
        token = ' ';
    }
}

bool MapCell::occupied() {
    return token == '#';
}

char MapCell::display() {
    return hasRobot ? 'R' : token;
}

void MapCell::enter() {
    hasRobot = true;
}

void MapCell::vacate() {
    hasRobot = false;
}
