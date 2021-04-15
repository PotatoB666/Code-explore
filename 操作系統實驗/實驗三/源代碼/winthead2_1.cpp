/*#include <Windows.h>
#include <stdio.h>

int turn = 0; //全局变量
unsigned long WINAPI runner(void* param)
{
	while (turn == 1);
	turn = 1;
	int t_num = (int)param;
	int i;
	for (i = 1; i <= 10; i++)
	{
		printf("Thread%d:%d\n", t_num, i);
		Sleep(1000);
	}
	turn = 0;
	return 0;
}

void main()
{
	int n = 0;
	int n2 = 1;
	unsigned long tid;
	unsigned long tid2;
	HANDLE hThread;
	HANDLE hThread2;
	hThread = CreateThread(0, 0, runner, (void*)n, 0, &tid);
	hThread2 = CreateThread(0, 0, runner, (void*)n2, 0, &tid2);

	WaitForSingleObject(hThread, -1);
	WaitForSingleObject(hThread2, -1);

	CloseHandle(hThread2);
	CloseHandle(hThread);
}*/