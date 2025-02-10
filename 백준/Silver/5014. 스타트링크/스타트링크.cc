#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;
int vis[1000002];
int main() {
	int f, s, g, u, d;
	cin >> f >> s >> g >> u >> d;

	queue<int> Q;
	vis[s] = 1;
	Q.push(s);

	while (vis[g]==0 && !Q.empty()) {
		int cur = Q.front(); Q.pop();
		for (int e : {u, d * -1}) {
			int next = cur + e;
			if (next<1 || next>f) continue;
			if (vis[next] > 0) continue;
			vis[next] = vis[cur] + 1;
			Q.push(next);
		}
	}

	if (vis[g] == 0) cout << "use the stairs";
	else cout << vis[g] - 1;

}