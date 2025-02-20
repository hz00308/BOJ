#include <iostream>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;
int board[102][102][102];
int dist[102][102][102];
int m, n, h;
int dx[6] = { 1, 0, 0, -1, 0, 0 };
int dy[6] = { 0, 1, 0, 0, -1, 0 };
int dz[6] = { 0, 0, 1, 0, 0, -1 };
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> m >> n >> h;
	queue<tuple<int, int, int>> Q;
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				cin >> board[i][j][k];
				if (board[i][j][k] == 1) Q.push(make_tuple(i, j, k));
				if (board[i][j][k] == 0) dist[i][j][k] = -1;
			}
		}
	}

	while (!Q.empty()) {
		tuple<int, int, int> cur = Q.front(); Q.pop();
		for (int dir = 0; dir < 6; dir++) {
			int nz = get<0>(cur) + dz[dir];
			int nx = get<1>(cur) + dx[dir];
			int ny = get<2>(cur) + dy[dir];
			if (nz < 0 || nx < 0 || ny < 0 || nz >= h || nx >= n || ny >= m) continue;
			if (dist[nz][nx][ny] != -1) continue;
			dist[nz][nx][ny] = dist[get<0>(cur)][get<1>(cur)][get<2>(cur)] + 1;
			Q.push(make_tuple(nz, nx, ny));
		}
	}

	int days = 0;
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				if (dist[i][j][k] == -1) {
					cout << -1;
					return 0;
				}
				days = max(days, dist[i][j][k]);
			}
		}
	}
	cout << days;

}