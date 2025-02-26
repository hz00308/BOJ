#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>
using namespace std;
#define X first
#define Y second
int dist[302][302];
int l;
int dx[8] = { -1, -2, -2, -1, 1, 2, 2, 1 };
int dy[8] = { -2, -1, 1, 2, 2, 1, -1, -2 };
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int T;
	cin >> T;
	while (T--) {
		cin >> l;
		//dist -1로 초기화
		for (int i = 0; i < l; i++) {
			fill(dist[i], dist[i] + l, -1);
		}
		queue < pair<int, int>> Q;
		int cx, cy, tx, ty;
		cin >> cx >> cy >> tx >> ty;
		dist[cx][cy] = 0;
		Q.push({ cx,cy });
		while (dist[tx][ty] == -1) {
			pair<int, int> cur = Q.front(); Q.pop();
			for (int dir = 0; dir < 8; dir++) {
				int nx = cur.X + dx[dir];
				int ny = cur.Y + dy[dir];
				if (nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
				if (dist[nx][ny] >= 0) continue;
				dist[nx][ny] = dist[cur.X][cur.Y] + 1;
				Q.push({ nx,ny });
			}
		}
		cout << dist[tx][ty] << '\n';
	}
}