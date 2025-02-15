#include <iostream>
#include <algorithm>
#include <queue>
#include <tuple>
#include <string>
using namespace std;
string board[1002];
int dist[1002][1002][2];
int n, m;
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> board[i];
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			dist[i][j][0] = -1;
			dist[i][j][1] = -1;
		}
	}

	queue<tuple<int, int, int>> Q;
	dist[0][0][0] = 1;
	Q.push({ 0, 0, 0 });

	while (!Q.empty()) {
		int x, y, broken;
		tie(x, y, broken) = Q.front(); Q.pop();
		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
			if (board[nx][ny] == '0' && dist[nx][ny][broken] == -1) {
				dist[nx][ny][broken] = dist[x][y][broken] + 1;
				Q.push({ nx, ny, broken });
			}
			if (board[nx][ny] == '1' && broken == 0 && dist[nx][ny][1] == -1) {
				dist[nx][ny][1] = dist[x][y][broken] + 1;
				Q.push({ nx, ny, 1 });
			}
		}
	}

	int ans1 = dist[n - 1][m - 1][0];
	int ans2 = dist[n - 1][m - 1][1];
	if (ans1 == -1 && ans2 == -1) cout << -1;
	else if (ans1 == -1) cout << ans2;
	else if (ans2 == -1) cout << ans1;
	else cout << min(ans1, ans2);
	
}