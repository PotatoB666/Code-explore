#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;
typedef struct
{
	int r, c;
	int** b;
}Matrix;
void InitialMatrix(Matrix* m, int r, int c, char z = 0, char E=0)
{
	m->r = r;
	m->c = c;
	m->b = (int**)calloc(r, sizeof(int*));
	for (int i = 0; i < m->r; i++)
		(m->b)[i] = (int*)calloc(c, sizeof(int));
	if (z)
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
			{
				if (E)
				{
					if (i == j)
					{
						m->b[i][j] = 1;
						continue;
					}
					m->b[i][j] = 0;
					continue;
				}
				m->b[i][j] = 0;
			}
}
void FreeMatrix(Matrix* m)
{
	for (int i = 0; i < m->r; i++)
	{
		free((m->b)[i]);
		m->b[i] = NULL;
	}
}
void Add(Matrix* m,int r1,int r2,double factor=1) // A=E(r1,r2(factor))*A
{
	for (int i = 0; i < m->c; i++)
		m->b[r1][i] += (factor * m->b[r2][i]);
}
void Divide(Matrix* m, int r1, double scaler = 1) // A=E(r1(scaler))*A
{
	for (int i = 0; i < m->c; i++)
		m->b[r1][i] /= scaler;
}
void Swap(Matrix* m, int r1, int r2)              // A=E(r1,r2)*A
{
	for (int i = 0; i < m->c; i++)
	{
		m->b[r1][i] ^= m->b[r2][i];
		m->b[r2][i] ^= m->b[r1][i];
		m->b[r1][i] ^= m->b[r2][i];
	}
}
void PrintMatrix(Matrix* m)
{
	printf("©°  ");
	for (int i = 0; i < m->c; i++)
		printf("%3d ", m->b[0][i]);
	printf("  ©´\n");
	for (int i = 1; i < m->r - 1; i++)
	{
		printf("©¦  ");
		for (int j = 0; j < m->c; j++)
		{
			printf("%3d ", m->b[i][j]);
		}
		printf("  ©¦\n");
	}
	printf("©¸  ");
	for (int i = 0; i < m->c; i++)
	{
		printf("%3d ", (m->b)[m->r - 1][i]);
	}
	printf("  ©¼\n");
}
void Sort(Matrix* m)
{
	int* x = (int*)malloc(sizeof(int) * m->r);
	for (int i = 0; i < m->r; i++)
	{
		int lastNoneZero = m->c + 1;
		for (int j = 0; j < m->c; j++)
		{
			if (m->b[i][j] != 0)
			{
				lastNoneZero = j;
				break;
			}
		}
		x[i] = lastNoneZero;
	}
	for (int i = 0; i < m->r; i++)
	{
		for (int j = i + 1; j < m->r; j++)
		{
			if (x[i] > x[j])
			{
				printf("Swap %d and %d row\n", i, j);
				Swap(m, i, j);
				PrintMatrix(m);
				x[i] ^= x[j];
				x[j] ^= x[i];
				x[i] ^= x[j];
			}
		}
	}
	free(x);
	x = NULL;
}
void ReducedRow(Matrix* m)
{
	for (int i = 0; i < m->r; i++)
	{
		//Check the problem
		int problem = 0;
		int last = -1;
		for (int k = 0; k < m->r; k++)
		{
			int indexOfFirst = m->c+1;
			for (int j = 0; j < m->c; j++)
			{
				if (m->b[k][j] != 0)
				{
					indexOfFirst = j;
					break;
				}
			}
			//printf("Row %d first %d\n", k, indexOfFirst);
			if (last > indexOfFirst && last != -1)
			{
				problem = 1;
			}
			last = indexOfFirst;
		}
		//First Reduce;
		for (int j = 0; j < m->r && last != -1 && !problem; j++)
		{
			if (j != i) {
				double factor = -(double)(m->b[j][last]) / (m->b[i][last]);
				printf("Add %.3lf*r%d to r%d\n", factor, i, j);
				Add(m, j, i, factor);
				PrintMatrix(m);
			}
		}
		//Simplify self row
		Add(m, i, i, 1-(double)(m->b[i][last]) / (m->b[i][last]));
		if (problem)
		{
			//sort
			Sort(m);
		}
	}
}
int main()
{
	Matrix m;
	printf("Please input row(s) and column(s):\n");
	int r, c;
	scanf_s("%d %d", &r, &c);
	InitialMatrix(&m, r, c, 1);
	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			int n;
			scanf_s("%d", &n);
			m.b[i][j] = n;
		}
	}
	Sort(&m);
	PrintMatrix(&m);
	ReducedRow(&m);
	printf("\n");
	PrintMatrix(&m);
	FreeMatrix(&m);
	return 0;
}
/*
4 5
2 4 1 3 1
4 2 1 5 5
3 2 2 1 0
4 0 2 3 5
*/
/*
3 4
1 2 1 -1
3 6 -1 -3
5 10 1 -5
*/