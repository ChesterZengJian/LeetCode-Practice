#include <iostream>

using namespace std;

enum romanNumber
{
    I = 1,
    V = 5,
    X = 10,
    L = 50,
    C = 100,
    D = 500,
    M = 1000
};

int getIntByRoman(char roman)
{
    romanNumber num;
    switch (roman)
    {
    case 'I':
        return I;
        break;
    case 'V':
        return V;
        break;
    case 'X':
        return X;
        break;
    case 'L':
        return L;
        break;
    case 'C':
        return C;
        break;
    case 'D':
        return D;
        break;
    case 'M':
        return M;
        break;
    default:
        return 0;
        break;
    }
};

int romanToInt(string s)
{
    int result = 0, nextNum = 0, currNum = 0;

    for (int i = s.size() - 1; i >= 0; i--)
    {
        currNum = getIntByRoman(s[i]);
        if (i < s.size() - 1)
        {
            nextNum = getIntByRoman(s[i+1]);
        }

        if ((currNum == I && (nextNum == V || nextNum == X)) || (currNum == X && (nextNum == L || nextNum == C)) || (currNum == C && (nextNum == D || nextNum == M)))
        {
            result -= currNum;
        }
        else
        {
            result += currNum;
        }
    }
    return result;
}

int main()
{
    string romanNum;
    while (romanNum != "exit")
    {
        cin >> romanNum;
        cout << "result=" << romanToInt(romanNum) << endl;
    }

    cout << "Exit Application" << endl;
}