#include <iostream>

using namespace std;
string solve(int n) {
    if (n % 2 == 0 && (n / 10 + n % 10) % 5 == 0)
        return "Yes";
    else
        return "No";
}

int main() {
    int n;
    cin >> n;
    cout << solve(n);
    return 0;
}