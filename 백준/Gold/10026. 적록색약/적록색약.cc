#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>
#include <string>
using namespace std;
#define X first
#define Y second
int n;
string board[102];
string board2[102];
int vis[102][102];
int vis2[102][102];
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> board[i];
		board2[i] = board[i];
		for (int j = 0; j < n; j++) {
			if (board2[i][j] != 'B') board2[i][j] = 'A';
		}
	}
	
	int r = 0;
	int g = 0;
	int b = 0;
	int a = 0;
	queue<pair<int, int>> qr;
	queue<pair<int, int>> qg;
	queue<pair<int, int>> qb;
	queue<pair<int, int>> qa;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			//R영역 개수 세기
			if (vis[i][j]==0 && board[i][j] == 'R') {
				vis[i][j] = 1;
				qr.push({ i, j });
				r++;
			}
			while (!qr.empty()) {
				pair<int, int> cur = qr.front(); qr.pop();
				for (int dir = 0; dir < 4; dir++) {
					int nx = cur.X + dx[dir];
					int ny = cur.Y + dy[dir];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					if (vis[nx][ny] || board[nx][ny] != 'R') continue;
					vis[nx][ny] = 1;
					qr.push({ nx,ny });
				}
			}
			//G영역 개수 세기
			if (vis[i][j] == 0 && board[i][j] == 'G') {
				vis[i][j] = 1;
				qg.push({ i, j });
				g++;
			}
			while (!qg.empty()) {
				pair<int, int> cur = qg.front(); qg.pop();
				for (int dir = 0; dir < 4; dir++) {
					int nx = cur.X + dx[dir];
					int ny = cur.Y + dy[dir];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					if (vis[nx][ny] || board[nx][ny] != 'G') continue;
					vis[nx][ny] = 1;
					qg.push({ nx,ny });
				}
			}
			//B영역 개수 세기
			if (vis[i][j] == 0 && board[i][j] == 'B') {
				vis[i][j] = 1;
				qb.push({ i, j });
				b++;
			}
			while (!qb.empty()) {
				pair<int, int> cur = qb.front(); qb.pop();
				for (int dir = 0; dir < 4; dir++) {
					int nx = cur.X + dx[dir];
					int ny = cur.Y + dy[dir];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					if (vis[nx][ny] || board[nx][ny] != 'B') continue;
					vis[nx][ny] = 1;
					qb.push({ nx,ny });
				}
			}
			//A영역 개수 세기
			if (vis2[i][j] == 0 && board2[i][j] == 'A') {
				vis2[i][j] = 1;
				qa.push({ i, j });
				a++;
			}
			while (!qa.empty()) {
				pair<int, int> cur = qa.front(); qa.pop();
				for (int dir = 0; dir < 4; dir++) {
					int nx = cur.X + dx[dir];
					int ny = cur.Y + dy[dir];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					if (vis2[nx][ny] || board2[nx][ny] != 'A') continue;
					vis2[nx][ny] = 1;
					qa.push({ nx,ny });
				}
			}
		}
	}
	cout << r + g + b << ' ' << a + b;
}