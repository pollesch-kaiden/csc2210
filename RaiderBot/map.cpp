/*
 * map.cpp
 *
 *      Author: Kaiden Pollesch
 */

#include "map.h"
#include "cell.h"
#include <iostream>
#include <string>

Map::Map() {
    for(int i = 0; i < WIDTH; ++i) {
        for(int j = 0; j < HEIGHT; ++j) {
            cells[i][j] = nullptr;
        }
    }
}

void Map::load() {
    std::string line;
    // Skip top border line
    std::getline(std::cin, line);

    for(int y = 0; y < HEIGHT; ++y) {
        std::getline(std::cin, line);
        // Assume line includes leading/trailing borders: "|...|"
        for(int x = 0; x < WIDTH; ++x) {
            cells[x][y] = new MapCell(x, y, line[x + 1]);
        }
    }

    // Skip bottom border line
    std::getline(std::cin, line);
}

void Map::write() {
    // Top border
    std::cout << "+" << std::string(WIDTH, '-') << "+" << std::endl;
    // Map rows
    for(int y = 0; y < HEIGHT; ++y) {
        std::cout << "|";
        for(int x = 0; x < WIDTH; ++x) {
            std::cout << cells[x][y]->display();
        }
        std::cout << "|" << std::endl;
    }
    // Bottom border
    std::cout << "+" << std::string(WIDTH, '-') << "+" << std::endl;
}

MapCell* Map::cellAt(int x, int y) {
    return cells[x][y];
}