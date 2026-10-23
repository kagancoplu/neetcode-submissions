class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        int fresh = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 2){
                    que.add(new int[]{r,c});
                }
                if(grid[r][c] == 1){
                    fresh++;
                }
            }
        }
        int min = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!que.isEmpty()){
            boolean rot = false;
            int size = que.size();
            for(int i = 0; i < size; i++){
                int[] cur = que.poll();
                for(int[] dir : dirs){
                    int dr = cur[0] + dir[0];
                    int dc = cur[1] + dir[1];
                    if(dr >= 0 && dr < rows && dc >=0 && dc < cols && grid[dr][dc] == 1){
                        rot = true;
                        fresh--;
                        grid[dr][dc] = 2;
                        que.add(new int[]{dr,dc});
                    }
                }
            }
            if (rot) min++;
        }
        return fresh > 0 ? -1 : min;
    }
}
