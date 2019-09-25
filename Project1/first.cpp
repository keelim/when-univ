#include<iostream>
using namespace std;
int main (void) {
	int testCase;
	cin >> testCase;

	for (int i=1; i <= testCase; i++) {
		cout << "#" << testCase << endl;
		int input;
		cin >> input;

		int** array=new int* [input]; //포인터로 접근을 한다.
		for (int i=0; i < input; i++) {
			array[i]=new int[input];
		}
		int size=input;
		int value=1, row=0, col=-1, inc=1;

		while (size > 0) {
			for (int i=0; i < size; i++) {
				col+=inc;
				array[row][col]=value;
				value++;
			}
			size--;
			if (size == 0) break;
			for (int i=0; i < size; i++) { 
				row+=inc;
				array[row][col]=value;
				value++;
			}
			inc*=-1;
		}
		for (int i=0; i < input; i++) {
			for (int j=0; j < input; j++) {
				cout << array[i][j] << " " << endl;
			}
			cout << endl;
		}
	}
	
}