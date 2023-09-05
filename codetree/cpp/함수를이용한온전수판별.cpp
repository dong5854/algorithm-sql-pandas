#include <iostream>

using namespace std;
bool OnJyunSu(int num) {
    if (num % 2 == 0) return false;
    else if (num % 10 == 5) return false;
    else if (num % 3 == 0 && num % 9 != 0) return false;
    return true;
}

int main() {
    int a,b;
    cin >> a >> b;

    int cnt = 0;
    for (int i = a; i <= b; i++) {
        if (OnJyunSu(i)) cnt++;
    }

    cout << cnt;
    return 0;
}