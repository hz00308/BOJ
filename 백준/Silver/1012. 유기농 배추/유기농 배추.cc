#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>
using namespace std;
#define X first
#define Y second
int board[52][52];
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int main() {

	int T;
	cin >> T;
	while (T--) {
		int m, n, k;
		cin >> m >> n >> k;
		while (k--) {
			int x, y;
			cin >> y >> x; //(열, 행)으로 입력이 주어져서 y, x 순으로 받음
			board[x][y] = 1;
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				queue<pair<int, int>> Q;
				if (board[i][j] == 1) {
					board[i][j] = 0;
					Q.push({ i, j });
					ans++;
				}
				while (!Q.empty()) {
					pair<int, int> cur = Q.front(); Q.pop();
					for (int dir = 0; dir < 4; dir++) {
						int nx = cur.X + dx[dir];
						int ny = cur.Y + dy[dir];
						if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
						if (board[nx][ny] == 0) continue;
						board[nx][ny] = 0;
						Q.push({ nx, ny });
					}
				}
			}
		}
		cout << ans << '\n';
	}
}