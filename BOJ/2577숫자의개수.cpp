#include<iostream>

using namespace std;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int A, B, C, mod;
    int num[10] = {0, };
    cin >> A >> B >> C;
    mod = A*B*C;

    while(mod != 0){
        num[mod%10]++;
        mod /= 10;
    }

    for(int n = 0; n<10 ; n++){
        cout << num[n] << "\n";
    }
}