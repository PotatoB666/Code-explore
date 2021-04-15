#include <iostream>
#define MAXN 101 //数组长度
#define MAXUINT 0xffffffff //最大无符号整数

using namespace std;
unsigned int t[MAXN]; //每个任务所需要的时间数,0号单元不使用
unsigned int m[MAXN]; //每个机器累计的时间,0号单元不使用
unsigned int minTime = MAXUINT; //记录最小的时间
unsigned int n, k; //n为任务数，k为机器的数量

void TraceBack(int task)
{
	if (task > n)
	{
		//统计所有机器中最大的时间数
		int u = 0;
		for (int i = 1; i <= k; i++)
		{
			if (m[i] > u)
				u = m[i];
		}

		if (u < minTime)
			minTime = u;
		return;
	}
	for (int i = 1; i <= k; i++)
	{
		//放入第i机器
		m[i] += t[task];
		TraceBack(task + 1);
		//取出
		m[i] -= t[task];
	}
}

/*
课本样例
7 3
2 14 4 16 6 5 3
*/
int main()
{
	cin >> n >> k;
	for (int i = 1; i <= n; i++)
		cin >> t[i];
	for (int i = 1; i <= k; i++)
		m[i] = 0;
	TraceBack(1);
	cout << minTime << endl;
	return 0;
}
