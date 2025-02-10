#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>
#include <vector>
#include <string>
using namespace std;
#define X first
#define Y second
int n;
string board[27];
int vis[27][27];
int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;

	//지도 입력받기
	for (int i = 0; i < n; i++) {
		cin >> board[i];
	}

	int num = 0;
	vector<int> V;
	queue<pair<int, int>> Q;
	//이중 for문 돌면서 집 찾기, BFS
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {

			if (board[i][j] == '1' && vis[i][j] == 0) {
				num++;
				vis[i][j] = 1;
				Q.push({ i,j });

				int area = 0;
				while (!Q.empty()) {
					pair<int, int> cur = Q.front(); Q.pop();
					area++;
					for (int dir = 0; dir < 4; dir++) {
						int nx = cur.X + dx[dir];
						int ny = cur.Y + dy[dir];
						if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
						if (vis[nx][ny] || board[nx][ny] == '0') continue;
						vis[nx][ny] = 1;
						Q.push({ nx,ny });
					}
				}
				V.push_back(area);
			}

		}
	}

	cout << num << '\n';
	sort(V.begin(), V.end());
	for (int e : V) cout << e << '\n';

}