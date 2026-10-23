class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands =0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1'){
                    bfs(grid,r,c);
                    islands++;
                }
            }
        }
        return islands;
    }

     public void bfs(char[][] grid, int r, int c){
        int rows = grid.length;
        int cols = grid[0].length;
        if(r < 0 || r >= rows || c < 0 || c>= cols || grid[r][c]=='0') return;
        grid[r][c] = '0';
        bfs(grid,r+1,c);
        bfs(grid,r-1,c);
        bfs(grid,r,c+1);
        bfs(grid,r,c-1);
}
}
