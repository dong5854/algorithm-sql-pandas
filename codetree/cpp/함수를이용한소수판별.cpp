#include <iostream>

using namespace std;
bool IsPrime(int num) {
    if (num == 1) return false;
    for (int i = 2; i < num; i++) {
        if (num % i == 0) return false;
    }
    return true;
}

int main() {
    int a, b;
    cin >> a >> b;
    int ans = 0;
    for (int i = a; i <=b; i++) {
        if (IsPrime(i)) ans += i;
    }
    cout << ans << endl;
    return 0;
}
