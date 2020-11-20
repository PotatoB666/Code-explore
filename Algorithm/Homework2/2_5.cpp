#include <iostream>
using namespace std;

template<typename T>
int check(T list[],int a,int b,T f)
{
	for(int i = a;i <= b;i++)
		if(list[i] == f)
			return 0;

	return 1;
}
template<typename T>
void aswap(T &a,T &b)
{
	int temp = a;
	a = b;
	b = temp;
}
template<typename T>
void Perm(T list[],int a,int b)
{
	if(a==b)
	{
		for(int i = 0;i<=b;i++)
			cout << list[i] << " ";
		cout << endl;
		return;
	}
	for(int i = a;i<=b;i++)
	{
		if(check(list,a,i-1,list[i]))
		{
			aswap(list[a],list[i]);
			Perm(list,a+1,b);
			aswap(list[a],list[i]);
		}
	}
}

int main(void)
{
	int n;
	cin >> n;
	char* list = new char[n];
	for(int i = 0;i < n;i++)
	{
		cin >> list[i];
	}
	Perm(list,0,n-1);

	return 0;
}
