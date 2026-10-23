class Solution {
    int rows,cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        List<List<Integer>> res = new ArrayList<>();
        for(int c = 0; c < cols; c++){
             dfs(0,c,pacific,heights[0][c],heights);
             dfs(rows-1,c,atlantic,heights[rows-1][c],heights);
            }
        for(int r = 0; r < rows;r++){
            dfs(r,0,pacific,heights[r][0],heights);
            dfs(r,cols-1,atlantic,heights[r][cols-1],heights);
        }
        for(int c = 0; c < cols;c++){
            for(int r = 0; r < rows;r++){
                if((pacific[r][c]) && (atlantic[r][c])){
                    res.add(List.of(r,c));
                }
            }
        }
        return res;
    }

        public void dfs(int r, int c, boolean[][] set, int prevheight,int[][] heights){
            if(r < 0 || r>= rows || c < 0 || c>= cols ||set[r][c] || heights[r][c] < prevheight){
                return;
            }
            set[r][c] = true;
            dfs(r+1,c,set,heights[r][c],heights);
            dfs(r-1,c,set,heights[r][c],heights);
            dfs(r,c+1,set,heights[r][c],heights);
            dfs(r,c-1,set,heights[r][c],heights);
        }
}
