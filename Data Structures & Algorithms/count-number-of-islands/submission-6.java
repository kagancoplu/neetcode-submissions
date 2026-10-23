class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islands =0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1' && !visited[r][c]){
                    bfs(grid, visited,r,c);
                    islands++;
                }
            }
        }
        return islands;
    }

     public void bfs(char[][] grid, boolean[][] visited, int r, int c){
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true; 
        q.add(new int[]{r,c});
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            for(int[] d : directions){
                int dr = row + d[0];
                int dc = col + d[1];
                if (dr >= 0 && dr < rows
                && dc >= 0 && dc < cols
                && grid[dr][dc] == '1'
                && !visited[dr][dc]){
                    q.add(new int[]{dr,dc});
                    visited[dr][dc] = true;
                }
                }
        }
        }
    
}
