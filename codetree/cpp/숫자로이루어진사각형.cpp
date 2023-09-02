#include <iostream>

using namespace std;

// n * n 크기의 사각형에 숫자를 출력하는 함수입니다.
void PrintNum(int n) {
    int cnt = 1;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cout << cnt << " ";
            cnt++;
            if(cnt == 10)
                cnt = 1;
        }
        cout << endl;
    }
}

int main() {
    // 변수 선언 및 입력:
    int row_num;
    cin >> row_num;

    PrintNum(row_num);

    return 0;
}