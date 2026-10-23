class Solution {
    int rows,cols;
    public void solve(char[][] board) {
         rows=  board.length;
         cols = board[0].length;
        boolean[][] o = new boolean[rows][cols];
        for(int r = 0; r < rows; r++){
            if(board[r][0] == 'O'){
                dfs(r,0,board,o);
            }
            if(board[r][cols-1] == 'O'){
                dfs(r,cols-1,board,o);
            }
        }
        for(int c = 0; c < cols; c++){
            if(board[0][c] == 'O'){
                dfs(0,c,board,o);
            }
            if(board[rows-1][c] == 'O'){
                dfs(rows-1,c,board,o);
            }
        }
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols;c++){
                if(!o[r][c]){
                    board[r][c] = 'X';
                }
            }
        }
    }


    public void dfs(int r , int c,char[][] board, boolean[][] o){
        if(r < 0 || r >= rows || c < 0 || c>= cols || board[r][c] == 'X' || o[r][c]){
            return;
        }
        o[r][c] = true;
        dfs(r-1,c,board,o);
        dfs(r+1,c,board,o);
        dfs(r,c-1,board,o);
        dfs(r,c+1,board,o);
    }
}
