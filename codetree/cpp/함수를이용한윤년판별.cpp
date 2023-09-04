#include <iostream>

using namespace std;

bool IsYunNyun(int year) {
    if (year % 4 == 0) {
        if (year % 100 == 0) {
            if (year % 400 == 0) return true;
            return false;
        }
        return true;
    }
    return false;
}

int main() {
    int y;
    cin >> y;
    if (IsYunNyun(y)) cout << "true";
    else cout << "false";
    return 0;
}