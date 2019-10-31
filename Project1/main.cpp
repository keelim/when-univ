#include<iostream>
using namespace std;

int main () {
	int testCase;
	cin >> testCase;
	for (auto i=0; i < testCase; i++) {
		int answer=0;
		for (auto j=0; j < 10; j++) {
			int temp;
			cin >> temp;
			answer+=temp;
		}
		answer/=10;
		cout << "#" << i << " " << answer << "\n";
	}
}