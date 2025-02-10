#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>
using namespace std;
#define X first
#define Y second
int board[102][102];
int vis[102][102];
int n;
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int main() {

	cin >> n;
	int mx = 0; //지역의 최대 높이
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> board[i][j];
			mx = max(mx, board[i][j]);
		}
	}

	int ans = 1; //안전한 영역의 최대 개수

	//1이상 mx미만 for문 돌기
	for (int h = 1; h < mx; h++) {

		//높이가 h이하인 지점은 모두 물에 잠김
		//안전한 영역은 높이가 h초과인 곳
		
		for (int i = 0; i < n; i++) fill(vis[i], vis[i] + n, 0); //vis 초기화
		queue<pair<int, int>> Q;

		//이중 for문 돌면서 안전한 영역 개수 구하기
		int num = 0; //안전한 영역의 개수
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				if (board[i][j] > h && vis[i][j] == 0) {
					num++;
					vis[i][j] = 1;
					Q.push({ i,j });
				}
				while (!Q.empty()) {
					pair<int, int> cur = Q.front(); Q.pop();
					for (int dir = 0; dir < 4; dir++) {
						int nx = cur.X + dx[dir];
						int ny = cur.Y + dy[dir];
						if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
						if (vis[nx][ny] == 1 || board[nx][ny] <= h) continue;
						vis[nx][ny] = 1;
						Q.push({ nx,ny });
					}
				}

			}
		}

		ans = max(ans, num);

	}

	cout << ans;

}