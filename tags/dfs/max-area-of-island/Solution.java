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