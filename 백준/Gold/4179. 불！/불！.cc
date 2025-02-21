#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>
#include <string>
using namespace std;
#define X first
#define Y second
int r, c;
string board[1002];
int dist1[1002][1002]; //불의 이동 기록
int dist2[1002][1002]; //지훈이의 이동 기록
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> r >> c;
	queue<pair<int, int>> Q1;
	queue<pair<int, int>> Q2;
	for (int i = 0; i < r; i++) {
		cin >> board[i];
		for (int j = 0; j < c; j++) {
			if (board[i][j] == '.') {
				dist1[i][j] = -1;
				dist2[i][j] = -1;
			}
			else if (board[i][j] == 'J') {
				dist1[i][j] = -1;
				Q2.push({ i,j });
			}
			else if (board[i][j] == 'F') {
				Q1.push({ i,j });
			}
		}
	}

	//불 전개시키기
	while (!Q1.empty()) {
		pair<int, int> cur = Q1.front(); Q1.pop();
		for (int dir = 0; dir < 4; dir++) {
			int nx = cur.X + dx[dir];
			int ny = cur.Y + dy[dir];
			if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
			if (dist1[nx][ny] >= 0) continue;
			dist1[nx][ny] = dist1[cur.X][cur.Y] + 1;
			Q1.push({ nx,ny });
		}
	}

	//지훈이 전개시키기
	while (!Q2.empty()) {
		pair<int, int> cur = Q2.front(); Q2.pop();
		for (int dir = 0; dir < 4; dir++) {
			int nx = cur.X + dx[dir];
			int ny = cur.Y + dy[dir];
			if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
				cout << dist2[cur.X][cur.Y] + 1;
				return 0;
			}
			if (dist2[nx][ny] >= 0) continue;
			if (dist1[nx][ny] != -1 && dist2[cur.X][cur.Y] + 1 >= dist1[nx][ny]) continue;
			dist2[nx][ny] = dist2[cur.X][cur.Y] + 1;
			Q2.push({ nx,ny });
		}
	}

	cout << "IMPOSSIBLE";
}