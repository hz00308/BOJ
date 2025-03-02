#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>
#include <string>
using namespace std;
#define X first
#define Y second
string board[1002];
int dist1[1002][1002];
int dist2[1002][1002];
int T;
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> T;
	while (T--) {

		int w, h;
		cin >> w >> h;
		queue<pair<int, int>> Q1;
		queue<pair<int, int>> Q2;
		for (int i = 0; i < h; i++) {
			cin >> board[i];
			for (int j = 0; j < w; j++) {
				if (board[i][j] == '.') {
					dist1[i][j] = -1;
					dist2[i][j] = -1;
				}
				else if (board[i][j] == '@') {
					dist1[i][j] = -1;
					dist2[i][j] = 0;
					Q2.push({ i,j });
				}
				else if (board[i][j] == '*') {
					dist1[i][j] = 0;
					Q1.push({ i,j });
					dist2[i][j] = 0;
				}
				else { //board[i][i] == '#'
					dist1[i][j] = 0;
					dist2[i][j] = 0;
				}
			}
		}
		//불 이동 기록
		while (!Q1.empty()) {
			pair<int, int> cur = Q1.front(); Q1.pop();
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.X + dx[dir];
				int ny = cur.Y + dy[dir];
				if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
				if (dist1[nx][ny] != -1) continue;
				dist1[nx][ny] = dist1[cur.X][cur.Y] + 1;
				Q1.push({ nx,ny });
			}
		}
		//지훈이 이동 기록
		bool next = false;
		while (!Q2.empty()) {
			pair<int, int> cur = Q2.front(); Q2.pop();
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.X + dx[dir];
				int ny = cur.Y + dy[dir];
				if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
					cout << dist2[cur.X][cur.Y] + 1 << '\n';
					next = true;
					break;
				}
				if (dist2[nx][ny] != -1) continue;
				if (dist1[nx][ny] != -1 && dist2[cur.X][cur.Y] + 1 >= dist1[nx][ny]) continue;
				dist2[nx][ny] = dist2[cur.X][cur.Y] + 1;
				Q2.push({ nx, ny });
			}
			if (next) break;
		}
		if (next) continue;
		cout << "IMPOSSIBLE\n";

	}
}