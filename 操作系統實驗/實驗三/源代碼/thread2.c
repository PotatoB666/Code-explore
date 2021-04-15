#include <pthread.h>
#include <sys/types.h>
#include <stdio.h>

void* runner(void* param)
{
	long n = (long)param;
	int i;
	for(i=0;i<10;i++)
	{
		printf("Thread%d:%d\n",n,i);
		sleep(1);
	}
	return NULL;
}

int main()
{
	int n1 = 0;
	int n2 = 1;

	pthread_t tid1;
	pthread_t tid2;

	pthread_create(&tid1,NULL,runner,(void*)n1);
	pthread_create(&tid2,NULL,runner,(void*)n2);

	pthread_join(tid1,0);
	pthread_join(tid2,0);
	return 0;
}
