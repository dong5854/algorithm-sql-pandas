#include <iostream>

using namespace std;
int getAns(int n) {
    int num = 0;
    for (int i = 1; i <= n; i++) {
        num += i;
    }
    return num / 10;
}

int main() {
    int n;
    cin >> n;
    cout << getAns(n);
    return 0;
}