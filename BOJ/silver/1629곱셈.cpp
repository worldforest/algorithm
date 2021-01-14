#include<iostream>

using namespace std;
long long func(int A, int B, int C){
    if (B == 1)
        return A;
    else{
        long long pow = func(A, B/2, C);
        if (B % 2)
            return ((pow*pow) % C*A) %C;
        else
            return pow*pow % C;
    }
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int A, B, C;
    cin >> A >> B >> C;
    cout << func(A%C, B, C) << "\n";
}