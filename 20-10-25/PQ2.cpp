#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter the value of n: ";
    cin >> n;

    int sum = 0;

    
    for (int i = 1; i <= n; i++) {
        sum += 2 * i;
    }

    cout << "Sum of first " << n << " even numbers = " << sum << endl;

    return 0;
}
