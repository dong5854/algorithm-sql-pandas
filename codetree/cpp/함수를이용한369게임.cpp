#include <iostream>

using namespace std;

bool Contains369(int num) {
    while (num > 0) {
        int firstDigit = num % 10;
        if (firstDigit == 3 || firstDigit == 6 || firstDigit == 9) {
            return true;
        }
        num /= 10;
    }
    return false;
}

bool Is369(int num) {
    if (num % 3 == 0) return true;
    else if (Contains369(num)) return true;
    return false;
}

int PlayGame(int a, int b) {
    int cnt = 0;
    for (int i = a; i <= b; i++) {
        if (Is369(i)) cnt++;
    }
    return cnt;
}

int main() {
    int a, b;
    cin >> a >> b;
    cout << PlayGame(a, b);
    return 0;
}