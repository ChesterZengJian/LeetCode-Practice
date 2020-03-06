#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

string ConvertByIterator(string s, int numRows)
{
  if (numRows == 1)
    return s;

  vector<string> rows(min(numRows, int(s.size())));
  int curRow = 0;
  bool goingDown = false;

  for (char c : s)
  {
    rows[curRow] += c;
    if (curRow == 0 || curRow == numRows - 1)
      goingDown = !goingDown;
    curRow += goingDown ? 1 : -1;
  }

  string ret;
  for (string row : rows)
    ret += row;
  return ret;
}

int main(int argc, char const *argv[])
{
  string s = "PAYPALISHIRING";
  int numRows = 4;
  cout << ConvertByIterator(s, numRows) << endl;
  return 0;
}
