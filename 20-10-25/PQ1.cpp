#include <iostream>
using namespace std;

int main() {
    int n, sum = 0;
    cout << "Enter the value of n: ";
    cin >> n;

    for (int i = 1; i <= n; i++) {
        sum += 2 * i;
    }

    cout << "Sum of first " << n << " even numbers is: " << sum << endl;
    return 0;
}
