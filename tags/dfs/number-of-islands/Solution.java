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