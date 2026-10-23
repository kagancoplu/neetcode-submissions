class Solution {
    int ROWS, COLS;
    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        int max = 0;
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == 1 && !visited[r][c]){
                    int cur = dfs(grid,visited,r,c);
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid,boolean[][] visited, int r, int c){
        if(r<0|| r >= ROWS|| c < 0 || c >= COLS || grid[r][c] == 0 || visited[r][c]) return 0;
        visited[r][c] = true;
        int res = 1;
        res +=
        dfs(grid,visited, r+1,c) +
        dfs(grid,visited,r-1,c) +
        dfs(grid,visited,r,c+1) +
        dfs(grid,visited,r,c-1);
        return res;
            }
}
