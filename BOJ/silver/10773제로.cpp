#include<iostream>
#include<stack>

using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int N, ans;
    cin >> N;
    stack<int> S;

    while(N--){
        int num;
        cin >> num;
        if(num==0){
            S.pop();
        }else{
            S.push(num);
        }
    }
    ans = 0;
    while(!S.empty()){
        ans+=S.top();
        S.pop();
    }
    cout << ans;

}