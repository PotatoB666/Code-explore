#include <iostream>
#include <cmath>
using namespace std;
int gcd(int a, int b)
{
	if (a < 0)
		a *= -1;
	if (b < 0)
		b *= -1;
	if (b > a)
	{
		b ^= a;
		a ^= b;
		b ^= a;
	}
	if (b == 0)
		return a;
	return gcd(b, a % b);
}
//·ÖÊýÀà
class Fraction
{
	int up, down;
public:
	Fraction()
	{
		this->up = 0;
		this->down = 1;
	}
	Fraction(int x)
	{
		this->up = x;
		this->down = 1;
	}
	Fraction(int x, int y)
	{
		this->up = x;
		this->down = y;
		Simplify();
	}
	Fraction& operator=(int n)
	{
		this->up = n;
		this->down = 1;
		return *this;
	}
	void Simplify()
	{
		int f = gcd(this->up, this->down);
		if (f == 0)
			return;
		this->down /= f;
		this->up /= f;
		if (this->up < 0 && this->down < 0)
		{
			this->up *= -1;
			this->down *= -1;
			return;
		}
		if (this->down < 0)
		{
			this->up *= -1;
			this->down *= -1;
		}
	}
	void Print(const int nextLine = 0)
	{
		if (this->down == 1)
		{
			cout << this->up;
			return;
		}
		if (this->up == 0)
		{
			cout << 0;
			return;
		}
		cout << this->up << "/" << this->down;
		if (nextLine)
			cout << endl;
	}
	Fraction Inverse()
	{
		if (this->down == 0)
			throw - 1;
		Fraction fnew(this->down, this->up);
	}
	Fraction operator+(Fraction a) const
	{
		int t1 = this->up * a.down + this->down * a.up;
		int t2 = this->down * a.down;
		if (t2 == 0)
			throw - 1;
		Fraction fnew(t1, t2);
		fnew.Simplify();
		return fnew;
	}
	Fraction operator-(Fraction a) const
	{
		int t1 = this->up * a.down - this->down * a.up;
		int t2 = this->down * a.down;
		if (t2 == 0)
			throw - 1;
		Fraction fnew(t1, t2);
		fnew.Simplify();
		return fnew;
	}
	Fraction operator*(Fraction a) const
	{
		int t1 = a.up * this->up;
		int t2 = a.down * this->down;
		if (t2 == 0)
			throw - 1;
		Fraction fnew(t1, t2);
		fnew.Simplify();
		return fnew;
	}
	Fraction operator/(Fraction a) const
	{
		int t1 = this->up * a.down;
		int t2 = this->down * a.up;
		if (t2 == 0)
			throw - 1;
		Fraction fnew(t1, t2);
		fnew.Simplify();
		return fnew;
	}
	int operator>(Fraction a) const
	{
		Fraction result = *this - a;
		if (result.up > 0)
			return 1;
		return 0;
	}
	int operator>=(Fraction a) const
	{
		Fraction result = *this - a;
		if (result.up >= 0)
			return 1;
		return 0;
	}
	int operator<=(Fraction a) const
	{
		Fraction result = *this - a;
		if (result.up <= 0)
			return 1;
		return 0;
	}
	int operator<(Fraction a) const
	{
		Fraction result = *this - a;
		if (result.up < 0)
			return 1;
		return 0;
	}
	int operator!=(Fraction a) const
	{
		Fraction result = *this - a;
		if (result.up != 0)
			return 1;
		return 0;
	}
	int operator==(Fraction a) const
	{
		Fraction result = *this - a;
		if (result.up == 0)
			return 1;
		return 0;
	}
	int Length()
	{
		int x = up < 0 ? -up : up;
		int y = down < 0 ? -down : down;
		int l = 0;
		if (up < 0)
		{
			l = 1;
		}
		if (up == 0 || down == 1)
		{
			l += 1;
			return l;
		}
		l += (int)(log10(x) + 1) + 1 + (int)(log10(y) + 1);
		return l;
	}
	~Fraction() {  }
};
//¾ØÕóÀà
class Matrix
{
public:
	int r, c;
	Fraction** base;
	Matrix(int r, int c)
	{
		this->r = r;
		this->c = c;
		this->base = (Fraction**)calloc(r, sizeof(Fraction*));
		for (int i = 0; i < r; i++)
			this->base[i] = (Fraction*)calloc(c, sizeof(Fraction));
	}
	void Add(int rd, int rs, Fraction scale)
	{
		for (int i = 0; i < this->c; i++)
		{
			Fraction t = this->base[rs][i] * scale;
			this->base[rd][i] = this->base[rd][i] + t;
		}
	}
	void Swap(int r1, int r2)
	{
		for (int i = 0; i < c; i++)
		{
			Fraction temp = this->base[r1][i];
			this->base[r1][i] = this->base[r2][i];
			this->base[r2][i] = temp;
		}
	}
	void RowReduce()
	{
		for (int i = 0; i < r;)
		{
			int i_last = c + 1;
			int _last = -1;
			int problem = 0;
			int nowLast = c + 1;
			for (int j = 0; j < r; j++)
			{
				for (int k = 0; k < c; k++) {
					if (base[j][k] != Fraction(0))
					{
						nowLast = k;
						if (j == i)
							i_last = k;
						break;
					}
				}
				if (_last > nowLast)
				{
					problem = 1;
					break;
				}
				_last = nowLast;
			}
			if (problem)
			{
				Sort();
				i = 0;
				continue;
			}
			if (i_last > c)
				break;
			for (int j = 0; j < r; j++)
			{
				if (i != j && base[j][i_last] != 0)
				{
					Fraction scaler = (base[j][i_last] * Fraction(-1)) / base[i][i_last];
					cout << "Add ";
					scaler.Print();
					cout << "*r" << i + 1 << " to r" << j + 1 << endl;
					Add(j, i, scaler);
					Print();
				}
			}
			if (i_last < c && base[i][i_last] != 1) {
				Fraction ft = (Fraction(1) - base[i][i_last]) / base[i][i_last];
				cout << "r" << i + 1 << "=" << "r" << i + 1 << "+" << "r" << i + 1 << "*";
				ft.Print();
				cout << endl;
				Add(i, i, ft);
			}
			Print();
			i++;
		}
		Sort();
	}
	void Sort()
	{
		int* first_set = new int[r];
		for (int i = 0; i < r; i++)
		{
			first_set[i] = c + 1;
			for (int j = 0; j < c; j++)
			{
				if (base[i][j] != Fraction(0))
				{
					first_set[i] = j;
					break;
				}
			}
		}
		for (int i = 0; i < r; i++)
		{
			for (int j = i + 1; j < r; j++)
			{
				if (first_set[i] > first_set[j])
				{
					cout << "Swap r" << i + 1 << " and r" << j + 1 << endl;
					Swap(i, j);
					first_set[i] ^= first_set[j];
					first_set[j] ^= first_set[i];
					first_set[i] ^= first_set[j];
					Print();
				}
			}
		}
		delete[] first_set;
	}
	void Print()
	{
		int* cMax = new int[c];
		for (int i = 0; i < c; i++)
		{
			int t_cmax = -1;
			for (int j = 0; j < r; j++)
			{
				int nowMax = base[j][i].Length();
				if (nowMax > t_cmax)
				{
					t_cmax = nowMax;
				}
			}
			cMax[i] = t_cmax;
		}
		cout << "[+]------------" << endl;
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				base[i][j].Print();
				//²¹¿Õ¸ñ
				for (int k = 0; k < cMax[j] - base[i][j].Length(); k++)
				{
					cout << " ";
				}
				cout << "|";
			}
			cout << endl;
		}
		cout << "[-]------------" << endl;
		delete[] cMax;
	}
	~Matrix()
	{
		for (int i = 0; i < r; i++)
		{
			free(base[i]);
		}
		free(base);
	}
};
int main()
{
	while (1) {
		int r, c;
		cout << "Input row(s) and column(s)" << endl;
		cin >> r >> c;
		Matrix m(r, c);
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				int t;
				cin >> t;
				m.base[i][j] = t;
			}
		}
		cout << endl;
		m.Print();
		cout << endl;
		m.RowReduce();
		m.Print();
	}
	return 0;
}
/*
3 3
1 2 3
3 2 1
2 1 3
*/

/*
4 5
1 1 -2 1 4
2 -1 -1 1 2
2 -3 1 -1 2
3 6 -9 7 9
*/
/*
5 5
1 2 3 4 5
2 3 4 5 1
3 4 5 1 2
4 5 1 2 3
5 1 2 3 4
*/