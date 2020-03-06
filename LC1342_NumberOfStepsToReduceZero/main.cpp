#include <iostream>

using namespace std;

int numberOfSteps(int num)
{
  int step = 0;
  while (num != 0)
  {
    if (num & 1 == 1)
      num = num - 1;
    else
      num = num / 2;
    step++;
  }
  return step;
}

int main(int argc, char const *argv[])
{
  int num;
  cin >> num;

  cout << numberOfSteps(num) << endl;

  return 0;
}