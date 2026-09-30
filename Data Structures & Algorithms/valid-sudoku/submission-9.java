class Solution {
    public boolean isValidSudoku(char[][] board) {
         List<List<HashSet<Character>>> hset3 = new ArrayList<>();
         for(int i = 0; i < 3; i++){
            hset3.add(new ArrayList<HashSet<Character>>());
            }
             for(int i = 0; i < 3; i++){
                hset3.get(i).add(new HashSet<Character>());
                hset3.get(i).add(new HashSet<Character>());
                hset3.get(i).add(new HashSet<Character>());
            }
        for(int i = 0; i < board.length; i++){
            HashSet<Character> hset = new HashSet<>();
            HashSet<Character> hset2 = new HashSet<>();
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != '.'){
                   if(!hset.add(board[i][j])){
                    return false;
                   }
                } if(board[j][i] != '.'){
                    if(!hset2.add(board[j][i])){
                        return false;
                    }
                }
                if(board[i][j] != '.'){
                 if(!hset3.get(i/3).get(j/3).add(board[i][j])){
                    return false;
                }
                }
                
            }
        }
        return true;
    }
}
