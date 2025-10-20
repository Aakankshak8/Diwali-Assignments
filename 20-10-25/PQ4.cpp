#include <iostream>
#include <cmath> 
using namespace std;

int main() {
    int n, original, remainder, digits = 0;
    double sum = 0;

    cout << "Enter a number: ";
    cin >> n;

    original = n;

    int temp = n;
    while (temp != 0) {
        digits++;
        temp /= 10;
    }

    temp = n;
    while (temp != 0) {
        remainder = temp % 10;
        sum += pow(remainder, digits);
        temp /= 10;
    }

    if ((int)sum == original)
        cout << "True (The number is an Armstrong number)" << endl;
    else
        cout << "False (The number is not an Armstrong number)" << endl;

    return 0;
}
