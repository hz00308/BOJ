#include <iostream>
using namespace std;
int func(int n, int r, int c) {
	//함수 정의: 2^n × 2^n인 2차원 배열에서 r행 c열을 몇 번째로 방문했는지 반환하는 함수
	//base condition: n이 0일 때 0 반환
	//재귀 식: n이 존재하는 사분면에 따라 재귀적으로 func 호출
	if (n == 0) return 0;
	int half = 1 << (n - 1);
	if (r < half && c < half) return func(n - 1, r, c);
	else if (r < half && c >= half) return half * half + func(n - 1, r, c - half);
	else if (r >= half && c < half) return 2 * half * half + func(n - 1, r - half, c);
	else return 3 * half * half + func(n - 1, r - half, c - half);
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, r, c;
	cin >> n >> r >> c;
	cout << func(n, r, c);
}