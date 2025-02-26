#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	string p;
	cin >> p;

	int ans = 0;
	//( => stack에 push 
	//) => 
	// 이전 글자가 (인 경우 (즉, () ) => (를 pop한 후, stack에 남은 ( 개수만큼 ans++
	// 이전 글자가 (이 아닌 경우 (즉, )) ) => ( 하나 pop & ans++ 

	stack<char> S;
	for (int i = 0; i < p.size(); i++) {
		if (p[i] == '(') {
			S.push('(');
		}
		else { // ')'
			if (p[i - 1] == '(') {
				S.pop();
				ans += S.size();
			}
			else {
				S.pop();
				ans++;
			}
		}
	}

	cout << ans;
}