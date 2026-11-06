class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(cur.children[i] == null){
                cur.children[i] = new TrieNode();
            }
            cur = cur.children[i];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    public boolean dfs(String word, int index, TrieNode node){
        if(node == null) return false;
        if(index == word.length()) return node.isWord;
        char c = word.charAt(index);
        if(c == '.'){
            for(TrieNode child : node.children){
                if(child != null && dfs(word,index + 1, child)){
                    return true;
                }
            }
            return false;
        }
        return dfs(word,index + 1,node.children[c - 'a']);
        }
}
