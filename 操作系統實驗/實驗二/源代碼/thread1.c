#include <pthread.h>
#include <stdio.h>

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

void main()
{
	pthread_t tid;
	long n = 5;
	pthread_create(&tid,0,runner,(void*)n);
	pthread_join(tid,0);

	printf("sum=%d\n",sum);
	return 0;
}
