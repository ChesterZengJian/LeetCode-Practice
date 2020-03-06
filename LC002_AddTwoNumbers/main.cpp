#include <iostream>

using namespace std;

struct ListNode
{
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

void PrintList(ListNode *head)
{
  while (head != nullptr)
  {
    cout << head->val;
    if (head->next != nullptr)
      cout << "->";
    head = head->next;
  }
}

ListNode *AddTwoNumbers(ListNode *l1, ListNode *l2)
{
  int carry = 0;
  ListNode *result = nullptr, *temp = nullptr, *prev = nullptr;
  while (l1 || l2)
  {
    int sum = carry + (l1 ? l1->val : 0) + (l2 ? l2->val : 0);
    carry = sum >= 10;
    sum %= 10;
    temp = new ListNode(sum);
    if (!prev)
      result = temp;
    else
      prev->next = temp;
    prev = temp;
    l1 = l1 ? l1->next : nullptr;
    l2 = l2 ? l2->next : nullptr;
  }
  if (carry)
    temp->next = new ListNode(carry);
  return result;
}

int main(int argc, char const *argv[])
{
  ListNode num1Head(2);
  ListNode num1Node1(4);
  ListNode num1Node2(3);
  num1Head.next = &num1Node1;
  num1Node1.next = &num1Node2;
  // PrintList(&num1Head);
  cout << endl;
  ListNode num2Head(5);
  ListNode num2Node1(6);
  ListNode num2Node2(4);
  num2Head.next = &num2Node1;
  num2Node1.next = &num2Node2;
  // PrintList(&num2Head);

  cout << endl;
  PrintList(AddTwoNumbers(&num1Head, &num2Head));
  return 0;
}
