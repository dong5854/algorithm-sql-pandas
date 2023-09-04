#include <iostream>

using namespace std;
int getMin(int a, int b, int c) {
    int ans = 987654321;
    ans = min(ans, a);
    ans = min(ans, b);
    ans = min(ans, c);
    return ans;
}

int main() {
    int a, b, c;
    cin >> a >> b >> c;
    cout << getMin(a,b,c);
    return 0;
}