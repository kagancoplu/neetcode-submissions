class Solution {
    int ROWS, COLS;
    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int max = 0;
        int cur = 0;
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == 1){
                    max = Math.max(max, dfs(grid,cur,r,c));
                    cur = 0;
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int cur, int r, int c){
        if(r<0|| r >= ROWS|| c < 0 || c >= COLS || grid[r][c] == 0) return 0;
        grid[r][c] = 0;
        return 1 +
        dfs(grid,cur, r+1,c) +
        dfs(grid,cur,r-1,c) +
        dfs(grid,cur,r,c+1) +
        dfs(grid,cur,r,c-1);
    }
}
