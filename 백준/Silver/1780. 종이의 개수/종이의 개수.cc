#include <iostream>
using namespace std;
int ans[3];
int board[2187][2187];
bool same(int x1, int x2, int y1, int y2) {
	for (int i = x1; i < x2; i++) {
		for (int j = y1; j < y2; j++) {
			if (board[x1][y1] != board[i][j]) return false;
		}
	}
	return true;
}
void func(int x1, int x2, int y1, int y2) {
	//함수 정의: -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 계산하는 함수
	//Base condition: 해당 구역의 숫자가 모두 같으면 해당 숫자 종이 개수 +1
	//재귀 식: 해당 구역의 숫자가 모두 같은 수가 아니라면 9분할
	if (same(x1, x2, y1, y2)) {
		ans[board[x1][y1] + 1] += 1;
		return;
	}
	else {
		int len = x2 - x1;
		int third = len / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				func(x1 + i * third, x1 + (i + 1) * third, y1 + j * third, y1 + (j + 1) * third);
			}
		}
	}
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> board[i][j];
		}
	}

	func(0, n, 0, n);
	for (int i = 0; i < 3; i++) cout << ans[i] << '\n';
}