## 岛屿的最大面积

[695. 岛屿的最大面积](https://leetcode-cn.com/problems/max-area-of-island/)

#### 解题思路：dfs

本题目同 [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/) 的思路是完全一样的，基本代码都吻合

示例：

```
  [1,1,0,0,0],
  [1,1,0,0,0],
  [0,0,1,0,0],
  [0,0,0,1,1]
```

对于这样的一个矩阵,岛屿的最大面积为4

思路为dfs;

问题解法：
设置一个感染方法，遍历矩阵，当遍历到矩阵当前元素值为“1”的时候，进入感染方法，感染方法可以让矩阵中的上下左右相邻为1的元素感染变为数值“2”，感染的同时，我们记录更新岛屿的面积；因为每一次感染，仅会在一片岛屿上感染，而无法感染其他的岛屿。

最后通过在遍历迭代中更新最大的面积即可。

#### 代码

Java:

```java
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        int res = 0;
        for(int i = 0; i < rLen; i++){
            for(int j = 0; j < cLen; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res,dfs(grid,i,j,rLen,cLen));
                }
            }
        }
        return res;
    }

    private static int dfs(int[][] grid,int r,int c,int rLen,int cLen){
        if(r < 0 || c < 0 || r >= rLen || c >= cLen || grid[r][c] != 1){
            return 0;
        }
        int res = 1;
        grid[r][c] = 2;
        res += dfs(grid,r - 1,c,rLen,cLen)
            + dfs(grid,r + 1,c,rLen,cLen)
            + dfs(grid,r,c - 1,rLen,cLen)
            + dfs(grid,r,c + 1,rLen,cLen);

        return res;    
    }
}
```

Go:

```go
func maxAreaOfIsland(grid [][]int) int {
    rLen,cLen,res := len(grid),len(grid[0]),0
    for i := 0; i < rLen; i++ {
        for j := 0; j < cLen; j++ {
            if grid[i][j] == 1 {
                res = max(res,dfs(grid,i,j,rLen,cLen))
            }
        }
    }
    return res
}

func dfs(grid [][]int,r int,c int,rLen int,cLen int) int{
    if r < 0 || c < 0 || r >= rLen || c >= cLen || grid[r][c] != 1 {
        return 0
    }

    res := 1
    grid[r][c] = 2
    res += dfs(grid,r - 1,c,rLen,cLen)
    res += dfs(grid,r + 1,c,rLen,cLen)
    res += dfs(grid,r,c - 1,rLen,cLen)
    res += dfs(grid,r,c + 1,rLen,cLen)
    return res
            
}

func max(a int, b int) int{
    if a >= b {
        return a
    }
    return b
}
```

