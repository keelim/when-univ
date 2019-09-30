#include<iostream>
#include<set>
#include<algorithm>

using namespace std;
int main (void) {

	for (int i=0; i < 10; i++) {
		set<int> answer;
		int testCase;
		cin >> testCase;

		int** array=new int* [100];
		for (int j=0; j < 100; j++) {
			array[j]=new int[100];
		}

		for (int k=0; k < 100; k++) {
			for (int l=0; l < 100; l++) {
				int temp;
				cin >> temp;
				array[k][l]=temp;
			}
		}

		int a=0, b=0, c=0, d=0;
		for (int j=0; j < 100; j++) {
			c+=array[j][j];
			d+=array[j][99 - j];
			for (int k=0; k < 100; k++) {
				a+=array[j][k];
				b+=array[k][j];
			}
			answer.insert (a);
			answer.insert (b);
			answer.insert (c);
			answer.insert (d);
			a=0, b=0, c=0, d=0;
		}
		int finalAnswer=*answer.rbegin ();
		cout << "#" << testCase << " " << finalAnswer << endl;


	}

}