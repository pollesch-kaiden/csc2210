# CSC 2210, SPA 4: Dig Dug Game

## Overview

This project is a simple implementation of the classic Dig Dug game in C++. The player navigates a grid, collects ammo, and attempts to defeat an enemy.

## The Game

- **Player Movement**: Use `W`, `A`, `S`, `D` to move up, left, down, and right respectively.
- **Firing**: Press `F` to fire a bullet, then use `W`, `A`, `S`, `D` to specify the direction.
- **Help Option**: Press `H` to display the help screen.
- **Quit**: Press `Q` to quit the game.
- **Enemy Movement**: The enemy, marked as `E`, moves either vertically or horizontally, as specified at the beginning of the game.
- **Ammo**: Ammo is depicted by the `^` symbol and can be picked up by moving to the square containing it.
- **Winning the Game**: To kill the enemy, the player needs to have ammo and fire in the correct direction.

## Game Setup

1. Clone the repository to your local machine.
    ```bash
    git clone https://github.com/polleschk/polleschk_SPA4_wumpus_variant.git
    ```

2. Open the project in your favorite terminal or IDE.

3. Run the game:
    Run using IntelliJ or your IDE and run with built-in run configuration.

## Design

- **Grid Layout**: The game is played on a grid of size 10x6.
- **Player**: The player starts at a random position and can move using the specified controls.
- **Enemy**: The enemy starts at a random position and moves either vertically or horizontally.
- **Ammo**: Ammo is placed randomly on the grid and can be picked up by the player.
- **Object-Oriented Design**: The game uses structs for the player, enemy, and bullets.

## Contributors

- [Kaiden](mailto:polleschk@msoe.edu) - Everything
    - Game Design and Implementation
    - Player and Enemy Movement

    - Ammo Collection and Firing Mechanism
