class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] res = new int[2];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        for(int i = 0; i < edges.length; i++){
            if(!union(edges[i][0],edges[i][1],parent)){
                res = edges[i];
            }
        }
        return res;
    }

    public int find(int n,int[] parent){
        if(parent[n] == n){
            return n;
        }
        parent[n] = find(parent[n],parent);
        return parent[n];
    }

    public boolean union(int n1, int n2,int[] parent){
        int p1 = find(n1,parent);
        int p2 = find(n2,parent);
        if(p1 == p2) return false;
        parent[p1] = p2;
        return true;
    }
}
