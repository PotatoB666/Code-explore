#include <iostream>
#include <mutex>
#define TRUE 1
using namespace std;
int min(int a, int b);
//�ݹ�ʽ
//s[i][j] = min(s[i+1][j-w[i]] + v[i],s[i+1][j]); if j>=w[i];
//        = s[i+1][j]; if j<w[n];
//�߽�����
//s[n][i] = 0; 0 <= i < w[n];
//        = v[n]; i >= w[n] && i <= c;
int s[7][11];
void dyn(int* w, int n, int* v, int c)
{
	//�߽����
	for (int i = 0; i < w[n] && i <= c; i++)
		s[n][i] = 0;
	for (int i = w[n]; i <= c; i++)
		s[n][i] = v[n];
	//һ�����
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
	//s[1][c]�����
	s[1][c] = s[2][c];
	if(c>=w[1])
		s[1][c] = min(s[2][c - w[1]] + v[1], s[2][c]);
}
//��Ʒ������ӡ����
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
	//0-1����
	int w[] = {0,1,3,1,5,2,1 };//Ȩ��
	int v[] = {0,5,5,2,2,4,6 };//��ֵ
	int c = 10;//������������ֵ
	int len = sizeof(w)/sizeof(w[0]) - 1;//��Ʒ����
	dyn(w, len, v, c);//��ʼ�ݹ�
	cout << "�������Ž�Ϊ:" << s[1][10] << endl;
	//PrintStatus(c,v,w,len);
	return 0;
}
