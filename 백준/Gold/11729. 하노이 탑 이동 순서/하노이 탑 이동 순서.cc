#include <iostream>
using namespace std;
void func(int a, int b, int k) {
	//원반 k개를 a번째 탑에서 b번째 탑으로 옮기는 함수
	//base condition: k가 1일 때 a b 출력
	//재귀 식:	원반 k-1개를 a번째 탑에서 6-a-b번째 탑으로 이동
	//			원반을 a번째 탑에서 b번째 탑으로 이동
	//			원반 k-1개를 6-a-b번째 탑에서 b번째 탑으로 이동
	if (k == 1) {
		cout << a << ' ' << b << '\n';
		return;
	}
	func(a, 6 - a - b, k - 1);
	cout << a << ' ' << b << '\n';
	func(6 - a - b, b, k - 1);
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n;
	cin >> n;

	cout << (1 << n) - 1 << '\n';
	func(1, 3, n);
}