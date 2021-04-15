/*#include <Windows.h>
#include <stdio.h>
unsigned long WINAPI runner(void* param)
{
	int t_num = (int)param;
	int i;
	for (i = 1; i <= 10; i++)
	{
		printf("Thread%d:%d\n", t_num, i);
		Sleep(1000);
	}
	return 0;
}

void main()
{
	int n = 0;
	unsigned long tid;
	HANDLE hThread;
	hThread = CreateThread(0, 0, runner, (void*)n, 0, &tid);
	WaitForSingleObject(hThread, -1);
	CloseHandle(hThread);
}*/