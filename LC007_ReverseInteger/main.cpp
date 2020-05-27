#include <iostream>

using namespace std;

// O(log(x))
int reverse(int x)
{
  int result = 0;
  while (x != 0)
  {
    int pop = x % 10;
    x /= 10;

    // INT_MAX=2147483647,so if pop>7,result will overflow
    if (result > (INT_MAX / 10) || (result == (INT_MAX / 10) && pop > 7))
    {
      return 0;
    }
    // INT_MIN=-2147483648
    if (result < (INT_MIN / 10) || (result == (INT_MIN / 10) && pop > 8))
    {
      return 0;
    }
    result = result * 10 + pop;
  }

  return result;
}

int main(int argc, char const *argv[])
{
  int num;
  cin >> num;
  cout<<reverse(num)<<endl;
  cout<<INT_MAX<<endl;
  cout<<INT_MIN/10<<endl;
  return 0;
}
