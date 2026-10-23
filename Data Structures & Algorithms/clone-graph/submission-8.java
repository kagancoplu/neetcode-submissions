/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<Node,Node>());
    }

    public Node dfs(Node node, HashMap<Node,Node> hmap){
        if(node == null) return null;
        if(hmap.containsKey(node)){
            return hmap.get(node);
        }
        Node newnode = new Node(node.val);
        hmap.put(node,newnode);
        for(Node nei : node.neighbors){
            newnode.neighbors.add(dfs(nei,hmap));
            }
        return newnode;
        }
}