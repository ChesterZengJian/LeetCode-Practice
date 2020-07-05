#include <iostream>
#include <string>
#include <vector>

using namespace std;

string longestCommonPrefix(vector<string> &strs)
{
    if (strs.size() == 0)
    {
        return "";
    }
    int strIdx = 0;
    string prefix = "";
    char currStr = strs[0][strIdx];
    while (true)
    {
        if (strIdx == strs[0].size())
        {
            return prefix;
        }
        for (size_t i = 0; i < strs.size(); i++)
        {
            if (strs[i][strIdx] != currStr)
            {
                return prefix;
            }
        }
        prefix += currStr;
        strIdx++;
    }
    return prefix;
}

int main()
{
    vector<string> strs = {"a"};
    cout << longestCommonPrefix(strs) << endl;
    cout << "Exit Application" << endl;
}