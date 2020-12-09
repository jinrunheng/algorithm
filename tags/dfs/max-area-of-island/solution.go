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