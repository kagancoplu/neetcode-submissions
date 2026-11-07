class TrieNode{
    HashMap<Character,TrieNode> children;
    boolean end;

    public TrieNode(){
        this.children = new HashMap<>();
        this.end =false;
    }

    public void addWord(String word){
        TrieNode cur = this;
        for(char c : word.toCharArray()){
            cur.children.computeIfAbsent(c,k -> new TrieNode());
            cur = cur.children.get(c);
        }
        cur.end = true;
    }
}

class Solution {
    int rows;
    int cols;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String w : words){
            root.addWord(w);
        }
        rows = board.length;
        cols = board[0].length;
        boolean[][] visit = new boolean[rows][cols];
        List<String> res = new ArrayList<>();
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                dfs(r,c,root,"",visit,res,board);
            }
        }
        return res;
    }

    public void dfs(int r, int c, TrieNode node, String word,boolean[][] visit,List<String> res,char[][] board){
         if(r< 0 || r >= rows || c< 0 || c >= cols || visit[r][c] || !node.children.containsKey(board[r][c])){
            return;
         }
         visit[r][c] = true;
         node = node.children.get(board[r][c]);
         word +=  board[r][c];
         if(node.end){
            res.add(word);
            node.end = false;
         }
        dfs(r-1,c,node,word,visit,res,board);
        dfs(r+1,c,node,word,visit,res,board);
        dfs(r,c-1,node,word,visit,res,board);
        dfs(r,c+1,node,word,visit,res,board);
        visit[r][c] = false;
    }
}
