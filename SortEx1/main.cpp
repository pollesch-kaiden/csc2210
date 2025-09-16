#include "sorting.h"
#include "stopwatch.h"
#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

void runSort(void (*sortFunc)(vector<int>&), const string& label)
{
    cout << "\n--- " << label << " ---\n";
    cout << setw(8) << "N" << setw(12) << "tavg(s)" << setw(8) << "RUNS"
         << setw(12) << "N^2" << setw(14) << "tavg/N^2" << "\n";

    vector<int> Ns = {1000, 2000, 4000, 8000, 16000};
    int RUNS = 1024;

    for (int i = 0; i < Ns.size(); ++i) {
        int N = Ns[i];

        if (i >= 2) RUNS /= 2; // Follow lab rule: halve RUNS after N=4000

        double total = 0;
        for (int r = 0; r < RUNS; ++r) {
            auto arr = generatePermutation(N);
            startTimer();
            sortFunc(arr);
            total += stopTimer();
        }

        double tavg = total / RUNS;
        double N2 = static_cast<double>(N) * N;
        double tavgOverN2 = tavg / N2;

        cout << setw(8) << N
             << setw(12) << fixed << setprecision(6) << tavg
             << setw(8) << RUNS
             << setw(12) << static_cast<long long>(N2)
             << setw(14) << scientific << tavgOverN2 << "\n";
    }
}

int main() {
    runSort(selectionSort, "Selection Sort");
    runSort(insertionSort, "Insertion Sort");
    return 0;
}
