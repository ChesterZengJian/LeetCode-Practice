#include <iostream>

using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode *mergeTwoLists(ListNode *l1, ListNode *l2)
{
    if (l1 == nullptr)
    {
        return l2;
    }
    if (l2 == nullptr)
    {
        return l1;
    }

    ListNode res(0);
    ListNode *curRes = &res;
    while (l1 != nullptr && l2 != nullptr)
    {
        if (l1->val < l2->val)
        {
            curRes->next = l1;
            l1 = l1->next;
        }
        else
        {
            curRes->next = l2;
            l2 = l2->next;
        }
        curRes = curRes->next;
    }
    curRes->next = l1 ? l1 : l2;
    return res.next;
}

ListNode *mergeTwoListsWithRecurise(ListNode *l1, ListNode *l2)
{
    if (l1 == nullptr)
    {
        return l2;
    }
    else if (l2 == nullptr)
    {
        return l1;
    }
    else if (l1->val < l2->val)
    {
        l1->next = mergeTwoListsWithRecurise(l1->next, l2);
        return l1;
    }
    else
    {
        l2->next = mergeTwoListsWithRecurise(l1, l2->next);
        return l2;
    }
}

void PrintList(ListNode *list)
{
    while (list != nullptr)
    {
        cout << list->val << "->";
        list = list->next;
    }
}

int main()
{
    ListNode *l1 = new ListNode(1);
    l1->next = new ListNode(2);
    l1->next->next = new ListNode(4);
    ListNode *l2 = new ListNode(1);
    l2->next = new ListNode(3);
    l2->next->next = new ListNode(4);
    ListNode *result = mergeTwoLists(l1, l2);
    PrintList(result);
    return 0;
}