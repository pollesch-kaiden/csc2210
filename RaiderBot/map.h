/*
  * map.h
  *
  *      Author: Kaiden Pollesch
  */

 #ifndef MAP_H_
 #define MAP_H_

 #define WIDTH 20
 #define HEIGHT 10

 class MapCell;

 class Map {
   MapCell *cells[WIDTH][HEIGHT];
 public:
   Map();
   void load();
   void write();
   MapCell* cellAt(int x, int y); // Add this method
 };

 #endif /* MAP_H_ */
