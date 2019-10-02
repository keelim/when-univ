#include<iostream>
#include<stdlib.h>
#include<cstring>
using namespace std;

int main (void) {
	int testCase;
	cin >> testCase;
	for (int i=0; i < testCase; i++) {
		int arraySize;
		cin >> arraySize;
		int index=(arraySize - 1) / 2;
		int answer=0;
		for (int i=0; i < arraySize; i++) {
			int temp=abs (index - i);
			string str1;
			cin >> str1;
			int n=str1.length ();
			char* tempArray=new char[n + 1];
			strcpy (tempArray, str1.c_str);

			for (int i=0; i < n; i++) {
				answer+=tempArray[i] - 48;
			}
			cout << "#" << testCase << " " << answer;
		}
	}
}