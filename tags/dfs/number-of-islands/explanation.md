## 岛屿数量

[200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)

#### 解题思路：dfs

本题是一道典型的深度优先搜索题目

题干：

```	
一个矩阵中只有0和1两种值
每个位置都可以和自己的上、下、左、右 四个位置相连；
如果有一片1连在一起，这个部分叫做一个岛，求一个 矩阵中有多少个岛？
举例：
0 0 1 0 1 0
1 1 1 0 1 0
1 0 0 1 0 0
0 0 0 0 0 0 
在这样一个矩阵中有三个岛
```

问题解法：

设置一个感染方法，遍历矩阵，当遍历到矩阵当前元素值为“1”的时候，进入感染方法，感染方法可以让矩阵中的上下左右相邻为1的元素感染变为数值“2”，岛的数量+1，感染完成后，继续遍历，遍历到2和0的时候跳过，当又遍历到有“1”的元素时继续感染，岛的数量++ ...  

#### 代码

Java:

```java
class Solution {
    public int numIslands(char[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        int res = 0;
        for(int i = 0; i < rLen; i++){
            for(int j = 0; j < cLen; j++){
                if(grid[i][j] == '1'){
                    infect(grid,i,j,rLen,cLen);
                    res++;
                }
            }
        }
        return res;
    }

    private static void infect(char[][] grid,int r,int c,int rLen,int cLen){
        if(r < 0 || c < 0 || r >= rLen || c >= cLen || grid[r][c] != '1'){
            return;
        }

        grid[r][c] = '2';
        infect(grid,r - 1,c,rLen,cLen);
        infect(grid,r + 1,c,rLen,cLen);
        infect(grid,r,c - 1,rLen,cLen);
        infect(grid,r,c + 1,rLen,cLen);
    }
}
```



