#include <iostream>

using namespace std;
bool IsEvenSum(int num) {
    int sum = 0;
    while (num > 0) {
        sum += num % 10;
        num /= 10;
    }
    return sum % 2 == 0;
}

bool IsPrime(int num) {
    if (num == 1) return false;
    for (int i = 2; i < num; i++) {
        if (num % i == 0) return false;
    }
    return true;
}


bool Valid(int num) {
    bool isEvenSum = IsEvenSum(num);
    bool isPrime = IsPrime(num);

    return isEvenSum && isPrime;
}

int main() {
    int a, b;
    cin >> a >> b;
    int cnt = 0;
    for (int i = a; i <= b; i++) {
        if (Valid(i)) cnt++;
    }
    cout << cnt;
    return 0;
}