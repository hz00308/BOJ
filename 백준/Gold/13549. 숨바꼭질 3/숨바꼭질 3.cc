#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;
int dist[100002];
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, k;
	cin >> n >> k;
	fill(dist, dist + 100002, -1);

	queue<int> Q;
	dist[n] = 0;
	Q.push(n);

	while (dist[k] == -1) {
		int cur = Q.front(); Q.pop();

		//순간이동
		for (int i = cur * 2; i <= 100000; i *= 2) {
			if (dist[i] == -1) {
				dist[i] = dist[cur];
				Q.push(i);
			}
			else {
				break;
			}
		}
		
		//걷기
		for (int e : {-1, 1}) { 
			int next = cur + e;
			if (next < 0 || next>100000)continue;
			if (dist[next] == -1) {
				dist[next] = dist[cur] + 1;
				Q.push(next);
			}
		}
		
	}

	cout << dist[k];

}