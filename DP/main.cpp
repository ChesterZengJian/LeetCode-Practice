#include <iostream>
#define GRID_ROW 3
#define GRID_COL 3

using namespace std;

// int countPath(bool grid[GRID_ROW][GRID_COL],int row,int col){
//     cout<<"now position:"<<row<<","<<col<<endl;
//     if(!grid[row][col])
//         return 0;
//     int maxRow=GRID_ROW-1,maxCol=GRID_COL-1;
//     if(row==maxRow&&col==maxCol)
//         return 1;
//     if(row==maxRow)
//         return countPath(grid,row,col+1);
//     if(col==maxCol)
//         return countPath(grid,row+1,col);

//     return countPath(grid,row+1,col)+countPath(grid,row,col+1);
// }

// int countPath(bool grid[GRID_ROW][GRID_COL],int row,int col,int paths[GRID_ROW][GRID_COL]){
//     cout<<"now position:"<<row<<","<<col<<endl;
//     if(!grid[row][col])
//         return 0;
//     int maxRow=GRID_ROW-1,maxCol=GRID_COL-1;
//     if(row==maxRow&&col==maxCol)
//         return 1;

//     if(row==maxRow)
//         paths[row][col]= countPath(grid,row,col+1,paths);
//     else if(col==maxCol)
//         paths[row][col]= countPath(grid,row+1,col,paths);
//     else
//         paths[row][col]= countPath(grid,row+1,col,paths)+countPath(grid,row,col+1,paths);

//     cout<<"paths :"<<paths[row][col]<<endl;
//     return paths[row][col];
// }

int countPath(bool grid[GRID_ROW][GRID_COL],int row,int col){
    int maxRow=GRID_ROW-1,maxCol=GRID_COL-1;
    int paths[GRID_ROW][GRID_COL];
    

    for(int i=maxRow;i>=0;i--){
        for(int j=maxCol;j>=0;j--){
            cout<<"now position:"<<i<<","<<j<<endl;
            if(i==maxRow&&j==maxCol)
                paths[i][j]=1;
            else if(!grid[i][j])
                paths[i][j]=0;
            else if(i==maxRow)
                paths[i][j]=paths[i][j+1];
            else if(j==maxCol)
                paths[i][j]=paths[i+1][j];
            else
                paths[i][j]=paths[i][j+1]+paths[i+1][j];
            cout<<"pahts="<<paths[i][j]<<endl;
        }
    }

    return paths[0][0];
}

int main(){
    // true is the road;false is stone
    bool grid[GRID_ROW][GRID_COL]={
        {true,true,true},
        {true,false,true},
        {true,true,true}
    };
    int paths[GRID_ROW][GRID_COL];
    cout<< countPath(grid,2,2);

    return 0;
}