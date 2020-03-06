#include <iostream>
#include <set>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;

int lengthOfLongestSubstringByBruteForce(string s)
{
  int result = 0, temp = 0;
  set<char> existedChar;
  for (int i = 0; i < s.size(); i++)
  {
    existedChar.clear();
    temp = 0;
    for (int j = i; j >= 0; j--)
    {
      if (!existedChar.count(s[j]))
      {
        temp++;
        existedChar.insert(s[j]);
      }
      else
      {
        result = max(result, temp);
        break;
      }
    }
    result = max(result, temp);
  }
  return result;
}

// O(2n)
int lengthOfLongestSubstringBySlidWindow(string s)
{
  int result = 0, i = 0, j = 0;
  set<char> existedChar;
  while (i < s.size() && j < s.size())
  {
    if (!existedChar.count(s[j]))
    {
      existedChar.insert(s[j++]);
      result = max(result, j - i);
    }
    else
    {
      existedChar.erase(s[i++]);
    }
  }
  return result;
}

// O(n)
int lengthOfLongestSubstringBySlidWindowOptimized(string s)
{
  int result = 0;
  map<char, int> existedChar;
  for (int i = 0, j = 0; j < s.size(); j++)
  {
    if (existedChar.count(s[j]))
    {
      i = max(existedChar[s[j]], i);
    }
    existedChar[s[j]] = j + 1;
    result = max(result, j - i + 1);
  }
  return result;
}

int main(int argc, char const *argv[])
{
  string str1 = "abcabcbb";
  string str2 = "bbbbb";
  string str3 = "pwwkew";
  string str4 = "dvdf";
  string str5 = "cdd";
  // cout << lengthOfLongestSubstringByBruteForce(str1) << endl;
  // cout << lengthOfLongestSubstringByBruteForce(str2) << endl;
  // cout << lengthOfLongestSubstringByBruteForce(str3) << endl;
  // cout << lengthOfLongestSubstringByBruteForce(str4) << endl;
  // cout << lengthOfLongestSubstringByBruteForce(str5) << endl;
  // cout << "Use sliding window" << endl;
  // cout << lengthOfLongestSubstringBySlidWindow(str1) << endl;
  // cout << lengthOfLongestSubstringBySlidWindow(str2) << endl;
  // cout << lengthOfLongestSubstringBySlidWindow(str3) << endl;
  // cout << lengthOfLongestSubstringBySlidWindow(str4) << endl;
  // cout << lengthOfLongestSubstringBySlidWindow(str5) << endl;
  cout << "Use sliding window optimized" << endl;
  cout << lengthOfLongestSubstringBySlidWindowOptimized(str1) << endl;
  cout << lengthOfLongestSubstringBySlidWindowOptimized(str2) << endl;
  cout << lengthOfLongestSubstringBySlidWindowOptimized(str3) << endl;
  cout << lengthOfLongestSubstringBySlidWindowOptimized(str4) << endl;
  cout << lengthOfLongestSubstringBySlidWindowOptimized(str5) << endl;
  return 0;
}
