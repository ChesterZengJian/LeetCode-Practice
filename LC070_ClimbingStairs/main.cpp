#include<iostream>
#include<vector>

using namespace std;

int climbingStairs(int n){
    if(n==0)
        return 1;
    if(n<0)
        return 0;
    return climbingStairs(n-1)+climbingStairs(n-2);
}

int climbingStairsDp(int n){
    if(n<=2)
        return n;
    vector<int> ways(n);
    ways[0]=1;
    ways[1]=2;
    for(int i=2;i<n;i++){
        ways[i]=ways[i-1]+ways[i-2];
    }
    return ways[n-1];
}

int main(){
    for(int i=1;i<10;i++){
        cout<<"i="<<i<<"\tclimbingStairs="<<climbingStairs(i)<<"\tclimbingStairsDp="<<climbingStairsDp(i)<<endl;
    }
}