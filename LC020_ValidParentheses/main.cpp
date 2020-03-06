#include <iostream>
#include <string>
#include <stack>
#include <map>

using namespace std;

bool isValidParentheses(string &parentheses)
{
  map<char, char> correctParentheses;
  correctParentheses[')'] = '(';
  correctParentheses['}'] = '{';
  correctParentheses[']'] = '[';

  stack<char> beginParentheses;
  for (char parenthesis : parentheses){
    if (correctParentheses.count(parenthesis) != 0){
      if (beginParentheses.size() != 0 && correctParentheses[parenthesis] == beginParentheses.top())
        beginParentheses.pop();
      else
        return false;
    }
    else{
      beginParentheses.push(parenthesis);
    }
  }
  if (beginParentheses.size() == 0)
    return true;
  return false;
}

int main(int argc, char const *argv[])
{
  string str = "]";
  bool result = isValidParentheses(str);
  cout << result << endl;

  return 0;
}