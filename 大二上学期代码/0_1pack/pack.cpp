#include <iostream>
#include <mutex>
#define TRUE 1
using namespace std;
int min(int a, int b);
//递归式
//s[i][j] = min(s[i+1][j-w[i]] + v[i],s[i+1][j]); if j>=w[i];
//        = s[i+1][j]; if j<w[n];
//边界条件
//s[n][i] = 0; 0 <= i < w[n];
//        = v[n]; i >= w[n] && i <= c;
int s[7][11];
void dyn(int* w, int n, int* v, int c)
{
	//边界情况
	for (int i = 0; i < w[n] && i <= c; i++)
		s[n][i] = 0;
	for (int i = w[n]; i <= c; i++)
		s[n][i] = v[n];
	//一般情况
	for (int i = n - 1; i >= 2; i--)
	{
		for (int j = 0; j <= c; j++)
		{
			if (j < w[i])
			{
				s[i][j] = s[i + 1][j];
				continue;
			}
			int minimal = min(s[i + 1][j], s[i + 1][j - w[i]] + v[i]);
			s[i][j] = minimal;
		}
	}
	//s[1][c]的情况
	s[1][c] = s[2][c];
	if(c>=w[1])
		s[1][c] = min(s[2][c - w[1]] + v[1], s[2][c]);
}
//物品向量打印函数
void PrintStatus(int c,int* v,int *w,int n)
{
	int nextI = 1;
	int nextJ = c;
	while(TRUE)
	{
		if (nextI == n)
		{
			cout << (s[nextI][nextJ] < w[n]) ? 1 : 0;
			break;
		}
	}
}
int min(int a, int b)
{
	return a > b ? a : b;
}


int main()
{
	//0-1背包
	int w[] = {0,1,3,1,5,2,1 };//权重
	int v[] = {0,5,5,2,2,4,6 };//价值
	int c = 10;//背包容许的最大值
	int len = sizeof(w)/sizeof(w[0]) - 1;//物品数量
	dyn(w, len, v, c);//开始递归
	cout << "背包最优解为:" << s[1][10] << endl;
	//PrintStatus(c,v,w,len);
	return 0;
}
