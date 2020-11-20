#include <iostream>
#define MAXN 101 //数组长度
#define MAXUINT 0xffffffff //最大无符号整数
#define Max(a,b,c) a > b ? (a > c ? a : c) : (b > c ? b : c) //返回三个数字中最大数

using namespace std;
int t[MAXN]; //每个任务所需要的时间数,0号单元不使用
int m[MAXN]; //每个机器累计的时间,0号单元不使用
unsigned int minTime = MAXUINT; //记录最小的时间
int n, k; //n为任务数，k为机器的数量

void TraceBack(int task)
{
	if (task > n)
	{
		//统计三个机器中最大的时间数
		int u = Max(m[1], m[2], m[3]);
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