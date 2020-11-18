#include<iostream>
#include<cmath>// #include<math.h>// ����ʱabs�����ᱨ�� ������ 
using namespace std;
#define Max 100
int n;
int x[Max];//������ 
int sum=0;
int flag=0;
int OK(int k)
{
	for(int i=1;i<k;i++)
	 {
	    if(x[i]==x[k]||abs(k-i)==abs(x[k]-x[i]))
	 	//if(x[i]==x[k]||(k-i)==(x[k]-x[i])||(k-i)==-(x[k]-x[i])) //Ҳ����ȷ�ģ��� 
	 	//if(x[i]==x[k]||(k-i)/(x[k]-x[i])==1||(k-i)/(x[k]-x[i])==-1) //����д�����Ǵ���ġ���Ϊ��k-i��3��(x[k]-x[i])=2ʱ ���������i��k�ʺ󲢲���һ��б���ϣ�����3/2������������������Ϊ1.���ͻ����ж�Ϊ��һ��б���ˣ���  
	 	  return 0;
	 }	 
    return 1;		
} 
void fun(int t)
{
	if(t>n && flag==0)
	{
		sum++;
		for(int i=1;i<=n;i++)
		  cout<<x[i];
		cout<<endl;		
		flag=1;
	}
	else
	{
		for(int i=1;i<=n && flag==0;i++)
		{
			x[t]=i;
			if(OK(t))
			{	
			    fun(t+1);
			}
		}
	}
	
}


int main()
{

	cin>>n;
	fun(1);
	/*cout<<"��������"<<sum<<endl;*/
	 
	return 0;
}
