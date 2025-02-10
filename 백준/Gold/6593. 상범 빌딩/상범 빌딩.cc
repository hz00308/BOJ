#include <iostream>
#include <algorithm>
#include <queue>
#include <tuple>
#include <string>
using namespace std;
string board[32][32];
int dist[32][32][32];
int l, r, c;
int dx[6] = { 1, 0, 0, -1, 0, 0 };
int dy[6] = { 0, 1, 0, 0, -1, 0 };
int dz[6] = { 0, 0, 1, 0, 0, -1 };
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	while (true) {

		cin >> l >> r >> c;
		if (l == 0) break;

		for (int i = 0; i < l; i++) for (int j = 0; j < r; j++) fill(dist[i][j], dist[i][j] + c, -1); //dist 초기화

		int tx, ty, tz; //E의 좌표를 저장
		queue<tuple<int, int, int>> Q;
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < r; j++) {
				cin >> board[i][j];
				for (int k = 0; k < c; k++) {
					if (board[i][j][k] == 'S') {
						dist[i][j][k] = 0;
						Q.push({ i,j,k });
					}
					if (board[i][j][k] == 'E') {
						tz = i;
						tx = j;
						ty = k;
					}
				}
			}
			//cin.ignore();
		}

		while (!Q.empty()) {
			tuple<int, int, int> cur = Q.front(); Q.pop();
			for (int dir = 0; dir < 6; dir++) {
				int nx = get<1>(cur) + dx[dir];
				int ny = get<2>(cur) + dy[dir];
				int nz = get<0>(cur) + dz[dir];
				if (nx < 0 || ny < 0 || nz < 0 || nx >= r || ny >= c || nz >= l) continue;
				if (dist[nz][nx][ny] >= 0 || board[nz][nx][ny] == '#') continue;
				dist[nz][nx][ny] = dist[get<0>(cur)][get<1>(cur)][get<2>(cur)] + 1;
				Q.push({ nz,nx,ny });
			}
		}

		if (dist[tz][tx][ty] == -1) cout << "Trapped!\n";
		else cout << "Escaped in " << dist[tz][tx][ty] << " minute(s).\n";

	}
}