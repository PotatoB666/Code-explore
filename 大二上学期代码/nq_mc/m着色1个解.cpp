/*
5 8
1 2
1 3
1 4
2 3
2 4
2 5
3 4
4 5
4
*/
#include<iostream>
using namespace std;
#define Max 100
int n;
int s;
int m;
int a[Max][Max];
int x[Max];//解向量 
int sum = 0;
int flag = 0;
int OK(int k)
{
	for (int i = 1; i < k; i++)
		if (a[i][k] == 1 && x[i] == x[k])
			return 0;
	return 1;
}
void fun(int t)
{
	if (t > n&& flag == 0)
	{
		sum++;
		for (int i = 1; i <= n; i++)
			cout << x[i];
		cout << endl;
		flag = 1;
	}
	else
	{
		for (int i = 1; i <= m && flag == 0; i++)
		{
			x[t] = i;
			if (OK(t) && flag == 0)
			{
				fun(t + 1);
			}
		}
	}

}


int main()
{
	int t1, t2;
	cin >> n >> s;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			a[i][j] = 0;
	while (s--)
	{
		cin >> t1 >> t2;
		a[t1][t2] = a[t2][t1] = 1;
	}
	cin >> m;
	fun(1);
	/*cout << "方案数：" << sum << endl;*/

	return 0;
}
