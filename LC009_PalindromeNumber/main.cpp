#include <iostream>

using namespace std;

bool isPalindrome(int x)
{
    if (x < 0)
        return false;
    int num = x;
    int newNum = 0;
    while (num != 0)
    {
        newNum *= 10;
        int remainder = num % 10;
        num = num / 10;
        newNum += remainder;
    }
    cout << newNum << endl;
    return newNum == x;
}

int main()
{
    int inputStr;
    cin >> inputStr;
    cout << (isPalindrome(inputStr) ? "true" : "false") << endl;
}