class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] rank = new int[edges.length +1];     
        int[] res = new int[2];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int i = 0; i < edges.length; i++){
            if(!union(edges[i][0],edges[i][1],rank,parent)){
                res = edges[i];
            }
        }
        return res;
    }

    public int find(int n,int[] parent){
        int p = parent[n];
        while(parent[p] != p){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean union(int n1, int n2,int[] rank,int[] parent){
        int p1 = find(n1,parent);
        int p2 = find(n2,parent);
        if(p1 == p2) return false;
        if(rank[p1] > rank[p2]){
            parent[p2] = parent[p1];
            rank[p1]+= rank[p2];
        }else{
            parent[p1] = parent[p2];
            rank[p2]+= rank[p1];
        }
        return true;
    }
}
