class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int INF =2147483647;
        Queue<int[]> que = new LinkedList<>();
        for(int r = 0; r < rows;r++){
            for(int c = 0; c < cols;c++){
                if(grid[r][c] == 0){
                    que.add(new int[]{r,c});
                }
            }
        }
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        int distance  =0;
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; i++){
                int[] cur = que.poll();
                for(int[] d : direction){
                    int dr = cur[0] + d[0];
                    int dc = cur[1] + d[1]; 
                    if(dr >= 0 && dr <rows && dc >= 0 && dc < cols && grid[dr][dc] == INF){
                        grid[dr][dc] = distance + 1;
                        que.add(new int[]{dr,dc});
                    }
                }
            }
            distance++;
        }
    }
}
