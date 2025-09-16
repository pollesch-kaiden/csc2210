#include <algorithm>
#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <limits>

using namespace std;

const int WIDTH = 10;
const int HEIGHT = 6;

struct Player {
    int x, y;
    int ammo;
};

struct Enemy {
    int x, y;
    bool movesVertically;
    bool active; // Flag to determine if the enemy is active
};

struct Bullet {
    int x, y;
    bool active; // Bullet can be active (in the air) or inactive (picked up)
};

Player player;
vector<Enemy> enemies; // Vector to store multiple enemies
vector<Bullet> bulletLocations; // Bullets that are placed on the ground

bool isAdjacent(int x1, int y1, int x2, int y2) {
    return abs(x1 - x2) + abs(y1 - y2) == 1;
}

void initializeGame() {
    srand(time(0));

    // Initialize player
    player.x = rand() % WIDTH;
    player.y = rand() % HEIGHT;
    player.ammo = 0; // Player starts with no ammo

    // Initialize enemies
    int numEnemies = rand() % 3 + 1; // Random number of enemies between 1 and 3
    for (int i = 0; i < numEnemies; ++i) {
        Enemy enemy;
        do {
            enemy.x = rand() % WIDTH;
            enemy.y = rand() % HEIGHT;
        } while ((enemy.x == player.x && enemy.y == player.y) || isAdjacent(player.x, player.y, enemy.x, enemy.y));

        enemy.movesVertically = rand() % 2;
        enemy.active = true;
        enemies.push_back(enemy);
    }

    // Place bullets on the map (random positions)
    for (int i = 0; i < 3; ++i) { // 3 bullets for this example
        Bullet bullet;
        do {
            bullet.x = rand() % WIDTH;
            bullet.y = rand() % HEIGHT;
        } while ((bullet.x == player.x && bullet.y == player.y) || any_of(enemies.begin(), enemies.end(), [&](Enemy &e) { return e.x == bullet.x && e.y == bullet.y; }));

        bullet.active = true; // Bullet is initially active (on the ground)
        bulletLocations.push_back(bullet);
    }
}

void drawGrid() {
    // system("CLS");

    cout << "+";
    for (int i = 0; i < WIDTH; ++i) cout << "- ";
    cout << "+" << endl;

    for (int i = 0; i < HEIGHT; ++i) {
        cout << "|";
        for (int j = 0; j < WIDTH; ++j) {
            bool printed = false;

            // Print player
            if (i == player.y && j == player.x) {
                cout << "P ";
                printed = true;
            }
            // Print enemies
            else {
                for (Enemy &enemy : enemies) {
                    if (enemy.active && i == enemy.y && j == enemy.x) {
                        cout << "E ";
                        printed = true;
                        break;
                    }
                }
                // Print bullets
                if (!printed) {
                    for (Bullet &bullet : bulletLocations) {
                        if (bullet.x == j && bullet.y == i && bullet.active) {
                            cout << "^ ";  // Bullet
                            printed = true;
                            break;
                        }
                    }
                }
            }

            // If nothing was printed, print empty space
            if (!printed) cout << "# ";
        }
        cout << "|" << endl;
    }

    cout << "+";
    for (int i = 0; i < WIDTH; ++i) cout << "- ";
    cout << "+" << endl;

    cout << "\nControls: WASD to move, F to fire, Q to quit, H for help" << endl;
    cout << "Ammo: " << player.ammo << " bullets" << endl;
}

void movePlayer(char input) {
    int newX = player.x;
    int newY = player.y;

    if (input == 'w' && player.y > 0) newY--;
    if (input == 's' && player.y < HEIGHT - 1) newY++;
    if (input == 'a' && player.x > 0) newX--;
    if (input == 'd' && player.x < WIDTH - 1) newX++;

    // Check if the new position is any enemy's position
    for (Enemy &enemy : enemies) {
        if (newX == enemy.x && newY == enemy.y) {
            cout << "\nYou moved onto the enemy's position and died!" << endl;
            exit(0);  // End the game
        }
    }

    // Update player's position
    player.x = newX;
    player.y = newY;

    // Check if the player picks up a bullet
    for (auto &bullet : bulletLocations) {
        if (bullet.x == player.x && bullet.y == player.y && bullet.active) {
            bullet.active = false;  // Mark bullet as picked up
            player.ammo++;          // Add one ammo to the player
            cout << "\nYou picked up a bullet!" << endl;
            break;  // Ensure only one bullet is picked up per movement
        }
    }
}

void moveEnemy() {
    for (Enemy &enemy : enemies) {
        if (!enemy.active) continue;

        int newX = enemy.x;
        int newY = enemy.y;

        if (enemy.movesVertically) {
            // Move vertically
            if (enemy.y > 0) newY--;
            else newY++;
        } else {
            // Move horizontally
            if (enemy.x > 0) newX--;
            else newX++;
        }

        // Check if the new position is the player's position
        if (newX == player.x && newY == player.y) {
            // Enemy does not move if the new position is the player's position
            return;
        }

        // Update enemy's position
        enemy.x = newX;
        enemy.y = newY;
    }
}

void fireBullet(char direction) {
    if (player.ammo > 0) {
        Bullet firedBullet;
        firedBullet.active = false;  // Initially, set the bullet to inactive (not on the ground)
        firedBullet.x = player.x;
        firedBullet.y = player.y;

        // Set the direction of the fired bullet
        if (direction == 'w' && firedBullet.y > 0) firedBullet.y--;  // Up
        else if (direction == 's' && firedBullet.y < HEIGHT - 1) firedBullet.y++; // Down
        else if (direction == 'a' && firedBullet.x > 0) firedBullet.x--;  // Left
        else if (direction == 'd' && firedBullet.x < WIDTH - 1) firedBullet.x++; // Right

        // Decrease ammo as the bullet is fired
        player.ammo--;

        // Check if the bullet hits any enemy (adjacent)
        for (Enemy &enemy : enemies) {
            if (enemy.active && ((firedBullet.x == enemy.x && abs(firedBullet.y - enemy.y) == 1) ||
                                 (firedBullet.y == enemy.y && abs(firedBullet.x - enemy.x) == 1))) {
                enemy.active = false; // Enemy is hit
                cout << "\nThe enemy has been hit!" << endl;
                if (all_of(enemies.begin(), enemies.end(), [](Enemy &e) { return !e.active; })) {
                    cout << "You won!" << endl;
                    exit(0);  // End the game
                }
                return;
            }
        }
        cout << "\nYou fired a bullet!" << endl;
    } else {
        cout << "\nYou don't have any ammo to fire!" << endl;
    }
}

void showHelp() {
    cout << "\n--- HELP MENU ---" << endl;
    cout << "Move using W (up), A (left), S (down), D (right)." << endl;
    cout << "Fire a bullet with F after having ammo." << endl;
    cout << "You can pick up bullets (^) by moving over them." << endl;
    cout << "Your goal is to avoid or defeat the enemy." << endl;
    cout << "Quit by pressing Q." << endl;
    cout << "Press any key to return..." << endl;
    cin.ignore();
    cin.get();
}

void gameLoop() {
    while (true) {
        drawGrid();

        char input;
        cin >> input;
        input = tolower(input);

        if (input == 'q') break;  // Quit the game
        if (input == 'h') {
            showHelp();
            continue;
        }
        if (input == 'f') {
            cout << "Which direction would you like to fire? (WASD): ";
            char direction;
            cin >> direction;
            fireBullet(tolower(direction));  // Fire the bullet
            continue;
        }

        movePlayer(input);  // Move player
        moveEnemy();  // Move enemies
    }
}

int main() {
    initializeGame();
    gameLoop();
    cout << "\nThanks for playing!" << endl;
    return 0;
}