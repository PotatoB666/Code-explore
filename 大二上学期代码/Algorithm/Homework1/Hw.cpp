#include <iostream>
using namespace std;

int sum = 0;
void T(int n)
{
    if(n==1)
    {
        sum++;
        return;
    }
    for(int i = 2;i < n;i++)
    {
        if(n%i==0)
        {
            T(n/i);
        }
    }
}

int main()
{
    T(12);
    cout << sum << endl;
}