#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// Brute Force: O(n^2)
// int maxProfit(vector<int> &prices)
// {
//     if (prices.size()<2)
//     {
//         return 0;
//     }

//     int maxProfit = 0;
//     for (int i = 0; i < prices.size() - 1; i++)
//     {
//         for (int j = i + 1; j < prices.size(); j++)
//         {
//             maxProfit = max(maxProfit, prices[j] - prices[i]);
//         }
//     }

//     return maxProfit;
// }

// One Pass
int maxProfit(vector<int> &prices)
{
    if (prices.size() < 2)
    {
        return 0;
    }

    int maxProfit = 0;
    int minPrice = INT32_MAX;

    for (int i = 0; i < prices.size(); i++)
    {
        if (minPrice > prices[i])
        {
            minPrice = prices[i];
        }
        else if (maxProfit < prices[i] - minPrice)
        {
            maxProfit = prices[i] - minPrice;
        }
    }

    return maxProfit;
}

int main()
{
    vector<int> prices = {7, 1, 5, 3, 6, 4};
    cout << "maxProfit=" << maxProfit(prices) << endl;
    return 0;
}