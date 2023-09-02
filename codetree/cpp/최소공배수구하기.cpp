#include <iostream>

using namespace std;

void FindLCM(int n, int m) {
    int gcd = 0;
    for (int i = 1; i <= min(n,m); i++) {
        if (n % i == 0 && m % i == 0) {
            gcd = i;
        }
    }
    cout << n * m / gcd;
    return;
}

int main() {
    int n, m;
    cin >> n >> m;
    FindLCM(n , m);
    return 0;
}