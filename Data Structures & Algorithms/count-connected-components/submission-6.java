class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer,List<Integer>> hmap = new HashMap<>();
        boolean[] visited = new boolean[n];
        int res = 0;
        for(int i = 0; i < n; i++){
            hmap.put(i,new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++){
            hmap.get(edges[i][0]).add(edges[i][1]);
            hmap.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i,hmap,visited);
                res++;
            }
        }
        return res;
    }

    public void dfs(int cur, Map<Integer,List<Integer>> hmap, boolean[] visited){
        visited[cur] = true;
        for(int next : hmap.get(cur)){
            if(!visited[next]){
                dfs(next,hmap,visited);
            }
        }
    }
}
