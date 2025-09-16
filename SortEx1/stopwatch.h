//
// Created by polleschk on 4/24/2025.
//
#ifndef STOPWATCH_H
#define STOPWATCH_H

using namespace std;

#include <chrono>

chrono::steady_clock::time_point start;

inline void startTimer() {
    start = chrono::steady_clock::now();
}

inline double stopTimer() {
    auto end = chrono::steady_clock::now();
    chrono::duration<double> elapsed = end - start;
    return elapsed.count();
}

#endif

