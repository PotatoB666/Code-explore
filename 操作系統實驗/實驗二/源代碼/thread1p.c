#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

int sum = 0;

void* runner(void* param)
{
	long num = (long)param;
	int i;
	for(i = 1;i<=num;i++)
	{
		sum+=i;
	}
}

void main(int argc,char* argv[])
{
	if(argc<=1)
	{
		printf("usage ./thread1p <num>\n");
		return;
	}
	pthread_t tid;
	long n = atoi(argv[1]);
	pthread_create(&tid,0,runner,(void*)n);
	pthread_join(tid,0);

	printf("sum=%d\n",sum);
	return 0;
}
