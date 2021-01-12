#include <iostream>
#include <queue>
#include <utility>
using namespace std;

int map[1001][1001];
int dist[1001][1001];
int m, n, ans=0;
int dir[4][2] = {{-1,0},{1,0},{0,-1},{0,1}};
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> m >> n;
    int ripe_tomato = 0;
    queue <pair<int, int>> Q;

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> map[i][j];
            if(map[i][j]==1){
                Q.push({i, j});
                ripe_tomato++;
            }
            if(map[i][j] == 0){
                dist[i][j] = -1;
            }
        }
    }
    // 이미 모든 토마토 다 익었으면 1 출력
    if (ripe_tomato == m * n)
        cout << "1";
    else{
        //bfs
        while(!Q.empty()){
            int cy = Q.front().first;
            int cx = Q.front().second;
            Q.pop();
            for(int d = 0; d < 4; d++){
                int ny = cy + dir[d][0];
                int nx = cx + dir[d][1];
                if(ny<0||nx<0||ny>=n||nx>=m)continue;
                if(dist[ny][nx] >= 0)continue;
                dist[ny][nx] = dist[cy][cx] + 1;
                Q.push({ny, nx});
            }
        }
        int day = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dist[i][j] == -1){
                    cout << -1;
                    return 0;
                }
                ans = max(ans, dist[i][j]);
            }
        }      
    }
    cout << ans;
}