#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter a number: ";
    cin >> n;

    int reversed = 0;
    int sign = (n < 0) ? -1 : 1; 
    n = abs(n);                  

    while (n > 0) {
        int digit = n % 10;          
        reversed = reversed * 10 + digit; 
        n /= 10;                     
    }

    reversed *= sign; 

    cout << "Reversed number = " << reversed << endl;

    return 0;
}
