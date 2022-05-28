#include<iostream>
#include<set>
#include<vector>

using namespace std;

int main_sub (void) {
	
}
class Problem {
public: void first () {
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
	  void second () {
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
	  void third () {
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
	  void m4 () {
		  int testCase;
		  cin >> testCase;

		  for (auto i=1; i <= testCase; i++) {
			  vector<int> vc;
			  for (auto i=0; i < 10; i++) {
				  int num;
				  cin >> num;
				  if (num % 2 != 0)
					  vc.push_back (num);
			  }
			  int odd_sum=0;
			  for (auto element : vc) {
				  odd_sum+=element;
			  }
			  cout << "#" << i << " " << odd_sum << endl;
		  }
	  }
};
