#include <iostream>
#include <cmath>
#include <ctime>
#define LENGTH 50
using namespace std;

int length(int n)
{
	int l = ceil(log2(n));
    return l==0?1:l;
}

//动态规划
void dyn(int *m,int n,int* t,int *s)
{
    t[0] = 11 + length(m[0]);
    s[0] = 0;
    for(int i = 1;i<=n;i++)
    {
        int bmax = length(m[i]);
        int minT = t[i-1] + 11 + length(bmax);
        int minI = i;
        for(int j = 2;j<=i&&j<=255;j++)
        {
            int b = length(m[i-j+1]);
            if(b>bmax) bmax = b;
            int tt = t[i-j] + 11 + j * bmax;
            if(tt<minT)
            {
                minT = tt;
                minI = j;
            }
        }
        s[i] = minI;
		t[i] = minT;
		cout << s[i] << " ";
    }
}

void printL(int* m,int a,int b)
{
	for(int i = a;i<=b;i++)
	{
		cout << m[i] << " ";
	}
}

void print(int* m,int n,int *s)
{
	if(s[n]==n)
	{
		printL(m,0,n);
		return;
	}
	print(m,n-s[n],s);
	cout << "|";
	printL(m,n-s[n]+1,n);
}

int main(int argc,char* argv[])
{
	int l;
	cin >> l;
    int* m = new int[l];//原始图形序列
    int* s = new int[l];//最佳位置储存
    int* t = new int[l];//最优存储大小
    srand(time(NULL));
    cout << "序列:";
    // 数据构造
	for(int i = 0;i<l;i++)
	{
		cin >> m[i];
	}
    for(int i = 0;i<l;i++)
    {
        cout << m[i] << " ";
    }
    cout << endl;
    dyn(m,l-1,t,s); //动态规划入口
    cout << "最短存储长度:" << t[l-1] << endl;
	cout << "分割情况:" << endl;
	print(m,l-1,s);
    return 0;
}
