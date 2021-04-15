#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

int sum = 0;
int sum2 = 0;

void* runner(void* param)
{
	long num = *((long*)(param+0));
	int i;
	for(i = 1;i<=num;i++)
	{
		int nowsum = *(int*)(param+sizeof(void*));
		nowsum += 1;
		*(int*)(param+sizeof(void*)) = nowsum;
	}
}

void main(int argc,char* argv[])
{
	if(argc<=2)
	{
		printf("usage ./thread1p <num1> <num2>\n");
		return;
	}
	pthread_t tid;
	pthread_t tid2;
	long n = atoi(argv[1]);
	long n2 = atoi(argv[2]);

	void* param1[] = {n,&sum};
	void* param2[] = {n2,&sum2};

	pthread_create(&tid,0,runner,(void*)param1);
	pthread_create(&tid2,0,runner,(void*)param2);
	pthread_join(tid,0);
	pthread_join(tid2,0);


	printf("sum=%d\n",sum);
	printf("sum2=%d\n",sum2);
}
