#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int minimumTotal(vector<vector<int>> &triangle)
{
    vector<int> result = triangle[triangle.size() - 1];
    // for (int row = triangle.size() - 1; row >= 0; row--)
    for (int row = triangle.size() - 2; row >= 0; row--)
    {
        for (int col = 0; col < triangle[row].size(); col++)
        {
            // if (row == triangle.size() - 1)
            // {
            //     result[col] = triangle[row][col];
            //     continue;
            // }
            // result[col] = min(triangle[row][col] + result[col], triangle[row][col] + result[col + 1]);
            result[col] = triangle[row][col] + min(result[col], result[col + 1]);
        }
    }

    return result[0];
}

int main()
{
    vector<vector<int>> demo = {
        {2},
        {3, 4},
        {6, 5, 7},
        {4, 1, 8, 3}};
    cout << demo[0][0] << endl;
    cout << minimumTotal(demo) << endl;
    return 0;
}