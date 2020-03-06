#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool IsPalindromicSubstring(string &str, int l, int r)
{
  while (l < r)
  {
    if (str[l] != str[r])
    {
      return false;
    }
    else
    {
      l++;
      r--;
    }
  }
  return true;
}

string LPSubstringByBruteForce(string str)
{
  if (str.size() < 1)
    return str;
  string result = "";
  for (int i = 0; i < str.size(); i++)
  {
    string substring(str, 0, 1);
    for (int j = i + 1; j < str.size(); j++)
    {
      substring += str[j];
      if (IsPalindromicSubstring(substring, 0, substring.size() - 1) && substring.size() > result.size())
        result = substring;
    }
  }
  return result;
}

// P[i, j] = P[i+1, j-1]， if ( s[i]==s[j] )
// P[i, j] = 0，if ( s[i] != s[j] )
// dp[j][i] means s[j, i] is palindrome or not
string LPSubstringByDP(string s)
{
  string result;
  vector<vector<int>> dp(s.size(), vector<int>(s.size(), 0));
  for (int i = 0; i < s.size(); ++i)
  {
    for (int j = i; j >= 0; --j)
    {
      if (s[i] != s[j])
      {
        dp[j][i] = 0;
        continue;
      }
      if (i - j <= 1)
        dp[j][i] = 1;
      else
        dp[j][i] = dp[j + 1][i - 1];
      if (dp[j][i] && result.size() < (i - j + 1))
        result = s.substr(j, i - j + 1);
    }
  }
  return result;
}

string LPSubstringByManacher(string s)
{
  if (s.empty())
    return "";
  string prep = "#";
  for (auto ch : s)
  {
    prep = prep + ch + "#";
  }
  const int size_p = prep.size();
  vector<int> dp(size_p, 0);
  int center = 0, bCur = 0;
  for (int i = 0; i < size_p; i++)
  {
    int mirror = center - (i - center);
    dp[i] = bCur <= i ? 0 : min(bCur - i, dp[mirror]);
    int start = i - dp[i], end = i + dp[i];
    while (start - 1 >= 0 && end + 1 < size_p && prep[start - 1] == prep[end + 1])
    {
      --start;
      ++end;
      ++dp[i];
    }
    if (i + dp[i] > bCur)
    {
      bCur = i + dp[i];
      center = i;
    }
  }
  center = max_element(dp.begin(), dp.end()) - dp.begin();
  return s.substr((center - dp[center]) / 2, dp[center]);
}

int ExpandAroundCenter(string s, int l, int r)
{
  if (s.size() < 1)
  {
    return 0;
  }
  while (l >= 0 && r < s.size() && s[l] == s[r])
  {
    l--;
    r++;
  }
  return r - l - 1;
}

string LPSubstringByExpandAroundCenter(string s)
{
  if (s.size() < 1)
  {
    return s;
  }
  int maxLPSLen = 0, start = 0;
  for (int i = 0; i < s.size(); i++)
  {
    int oddLen = ExpandAroundCenter(s, i, i);
    int evenLen = ExpandAroundCenter(s, i - 1, i);
    int currMaxLen = max(oddLen, evenLen);
    if (maxLPSLen < currMaxLen)
    {
      maxLPSLen = currMaxLen;
      start = i - (maxLPSLen / 2);
    }
  }
  return s.substr(start, maxLPSLen);
}

int main(int argc, char const *argv[])
{
  string str1 = "adbab";
  string str2 = "cbbd";
  string str3 = "a";
  // cin >> str;
  // cout << LPSubstringByBruteForce(str1) << endl;
  // cout << LPSubstringByDP(str1) << endl;
  // cout << LPSubstringByManacher(str1);
  // cout << LPSubstringByExpandAroundCenter(str1)<<endl;
  cout << LPSubstringByExpandAroundCenter(str3) << endl;
  return 0;
}
