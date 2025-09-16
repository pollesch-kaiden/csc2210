#include <iostream>
#include <limits>  // For input validation
using namespace std;

constexpr int MAX_INPUTS = 1000;

// Function to validate user input
int getValidInteger() {
    int value;
    while (true) {
        cin >> value;
        if (cin.fail()) {
            cin.clear(); // Clear error flag
            cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Ignore invalid input
            cout << "Invalid input. Enter an integer: ";
        } else {
            return value;
        }
    }
}

// Function to find the minimum and maximum value in an array
void findMinMax(const int arr[], int size, int &min, int &max) {
    min = max = arr[0];
    int i = 1;
    while (i < size) {
        if (arr[i] < min) min = arr[i];
        if (arr[i] > max) max = arr[i];
        i++;
    }
}

// Function to count occurrences of each value in an array
void countOccurrences(const int arr[], int size, int min, int max, int count_arr[]) {
    int i = 0;
    while (i < size) {
        count_arr[arr[i] - min]++;
        i++;
    }
}

// Function to print the histogram
void printHistogram(const int count_arr[], int min, int max) {
    cout << "\nHistogram:\n";
    int i = max;
    while (i >= min) {
        cout << i << (i < 10 ? "   |" : "  |");
        for (int j = 0; j < count_arr[i - min]; j++) {
            cout << "#";
        }
        cout << endl;
        i--;
    }
}

int main() {
    int numElements;

    // Step 1: Prompt user for number of elements
    cout << "Enter the number of elements: ";
    numElements = getValidInteger();

    // Validate number of elements
    if (numElements <= 0 || numElements > MAX_INPUTS) {
        cout << "Invalid input size. Please enter a value between 1 and " << MAX_INPUTS << ".\n";
        return 1;
    }

    int arr[MAX_INPUTS]; // Array to store user input
    int i = 0;

    // Step 2: Read user inputs using while loop
    cout << "Enter the numbers:\n";
    while (i < numElements) {
        arr[i] = getValidInteger();
        i++;
    }

    // Step 3: Find min and max values
    int min, max;
    findMinMax(arr, numElements, min, max);

    // Step 4: Create and initialize frequency array
    int range = max - min + 1;
    int count_arr[range] = {0};

    // Step 5: Count occurrences
    countOccurrences(arr, numElements, min, max, count_arr);

    // Step 6: Print histogram
    printHistogram(count_arr, min, max);

    return 0;
}
