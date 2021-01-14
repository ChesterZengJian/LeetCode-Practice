#include <iostream>
#include <vector>

using namespace std;

vector<bool> prefixesDivBy5(vector<int> &A)
{
    int prefix = 0;
    vector<bool> result;
    for (size_t i = 0; i < A.size(); i++)
    {
        prefix = ((prefix << 1) + A[i])%5;
        result.push_back(prefix == 0);
    }

    return result;
}

int main()
{
    vector<int> nums = {0, 1, 1, 1, 1, 1};
    vector<bool> result = prefixesDivBy5(nums);
    for (size_t i = 0; i < result.size(); i++)
    {
        cout << result[i] << endl;
    }
}
