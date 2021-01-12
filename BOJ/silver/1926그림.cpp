#include <iostream>
#include <queue>
#include <utility>
using namespace std;

int n,m,maxarea,num;//max 최대개수 num 그림의 개수
int map[501][501];
bool visited[501][501];
int dir[4][2] = {{-1,0},{1,0},{0,-1},{0,1}};
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    for(int r = 0; r < n; r++){
        for(int c = 0; c < m; c++)
            cin >> map[r][c];
    }
    // int maxarea = 0;
    for(int r = 0; r < n; r++){
        for(int c = 0; c < m; c++){
            if (map[r][c] == 0 || visited[r][c])
                continue;
            num++;
            visited[r][c] = 1;
            queue<pair<int,int>> Q;
            Q.push({r ,c});
            int area = 0;// 초기화 꼭!!
            while(!Q.empty()){
                area++;
                pair<int, int> cur = Q.front();
                Q.pop();
                for(int d = 0; d < 4; d++){
                    int nr = cur.first + dir[d][0];
                    int nc = cur.second + dir[d][1];
                    if(nr < 0 || nc <0 || nr >= n || nc >= m) continue;
                    if(visited[nr][nc] || map[nr][nc] != 1) continue;
                    visited[nr][nc] = 1;
                    Q.push({nr, nc});
                }
            }
            maxarea = max(maxarea, area);
        }
    }
    cout << num << "\n" << maxarea;
}