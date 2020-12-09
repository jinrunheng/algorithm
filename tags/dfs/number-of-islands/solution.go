func numIslands(grid [][]byte) int {
    rLen,cLen,res := len(grid),len(grid[0]),0
    for i := 0; i < rLen; i++ {
        for j := 0; j < cLen; j++ {
            if grid[i][j] == '1' {
                dfs(grid,i,j,rLen,cLen)
                res += 1
            }
        }
    }
    return res
}

func dfs(grid [][]byte,r,c,rLen,cLen int){
    if r < 0 || c < 0 || r >= rLen || c >= cLen || grid[r][c] != '1' {
        return
    }

    grid[r][c] = '2'
    dfs(grid,r - 1,c,rLen,cLen)
    dfs(grid,r + 1,c,rLen,cLen)
    dfs(grid,r,c - 1,rLen,cLen)
    dfs(grid,r,c + 1,rLen,cLen)
}