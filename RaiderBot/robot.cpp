/*
 * robot.cpp
 *
 *      Author: Kaiden Pollesch
 */

#include "robot.h"
#include "map.h"
#include "cell.h"
#include <iostream>

Robot::Robot(Map *map, int startx, int starty) : map(map), x(startx), y(starty), gold(0) {
    map->cellAt(x, y)->enter();
    // pick up gold if the starting cell has it
    if (map->cellAt(x, y)->hasGold()) {
        gold++;
        map->cellAt(x, y)->removeGold();
    }
}

void Robot::displayStatus() {
    std::cout << "Robot at " << x << ", " << y << " (" << gold << " gold)";
}

bool Robot::move(char direction) {
    int newX = x, newY = y;
    switch (direction) {
    case 'e': newX++; break;
    case 'w': newX--; break;
    case 'n': newY--; break;
    case 's': newY++; break;
    default: return false;
    }
    // Check if the new position is within the map boundaries
    if (newX < 0 || newX >= WIDTH || newY < 0 || newY >= HEIGHT) {
        // If the robot tries to move out of bounds, it should break
        return false;
    }
    if (map->cellAt(newX, newY)->occupied()) {
        // If the robot tries to move into an occupied cell, it should break
        return false;
    }
    map->cellAt(x, y)->vacate();
    x = newX;
    y = newY;
    map->cellAt(x, y)->enter();

    // Collect gold
    if (map->cellAt(x, y)->hasGold()) {
        gold++;
        map->cellAt(x, y)->removeGold();
    }

    // Thief steals gold
    if (map->cellAt(x, y)->hasThief()) {
        gold--;
        if (gold < 0) {
            std::cout << "Robot now owes the bank "
                      << -gold << " pieces." << std::endl;
        }
    }
    return true;
}

bool Robot::move(std::string commands) {
    for (char command : commands) {
        if (!move(command)) {
            return false;
        }
    }
    return true;
}