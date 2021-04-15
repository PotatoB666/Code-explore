#include <pthread.h>
#include <sys/types.h>
#include <stdio.h>
#define TRUE 1
#define FALSE 0

int flag[2] = {FALSE},turn;
void* runner(void* param)
{
	long n = (long)param;

	flag[n] = TRUE;
	turn = 1;
	while(turn==1&&flag[1-n]);
	int i;
	for(i=0;i<10;i++)
	{
		printf("Thread%d:%d\n",n,i);
		sleep(1);
	}
	flag[0] = FALSE;
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
