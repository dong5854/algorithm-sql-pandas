#include <iostream>

using namespace std;
void FindGcd(int n, int m) {
    int gcd = min(n, m);
    while (n % gcd != 0 || m % gcd != 0) {
        gcd--;
    }
    cout << gcd;
    return;
}

int main() {
    int n,m;
    cin >> n >> m;
    FindGcd(n,m);
    return 0;
}