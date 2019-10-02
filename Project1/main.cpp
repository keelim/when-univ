#include<iostream>
#include<vector>
using namespace std;

int main () {
	int testCase;
	cin >> testCase;

	for (auto i=1; i < testCase; i++) {
		int answer;
		vector<int> list;
		for (auto i=0; i < 5; i++) {
			int num;
			cin >> num;
			list.push_back (num);
		}

		int a, b, c, d, e,f,g;
		a=list[0];
		b=list[1];
		c=list[2];
		d=list[3];
		e=list[4];
		f=a * e;

		if (e <= c) {
			g=b;
		}
		else {
			g=b +(e - c) * d;
		}
		answer=(f > g) ? g : f;
		cout << "#" << i << " " << answer << endl;
	}
}