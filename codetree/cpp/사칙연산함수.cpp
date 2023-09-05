#include <iostream>

using namespace std;
int main() {
    int a, c;
    char o;
    cin >> a >> o >> c;
    switch(o) {
        case '+':
            cout << a << ' ' << o << ' ' << c << ' ' << '=' << ' ' << a + c;
            break;
        case '-':
            cout << a << ' ' << o << ' ' << c << ' ' << '=' << ' ' << a - c;
            break;
        case '/':
            cout << a << ' ' << o << ' ' << c << ' ' << '=' << ' ' << a / c;
            break;
        case '*':
            cout << a << ' ' << o << ' ' << c << ' ' << '=' << ' ' << a * c;
            break;
        default:
            cout << "False";
    }
    return 0;
}