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

	fill(dist, dist + 100001, -1);

	queue<int> Q;
	dist[n] = 0;
	Q.push(n);
	while (dist[k]==-1) { //n==k인 경우도 고려해야 함
		int cur = Q.front(); Q.pop();
		for (int next : {cur - 1, cur + 1, cur * 2}) {
			if (next < 0 || next > 100000) continue;
			if (dist[next] >= 0) continue;
			dist[next] = dist[cur] + 1;
			Q.push(next);
		}
	}
	cout << dist[k];
}