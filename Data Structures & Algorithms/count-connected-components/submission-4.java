class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> hmap = new HashMap<>();
        Set<Integer> visited = new HashSet<Integer>();
        int res = 0;
        for(int i = 0; i < n; i++){
            hmap.put(i, new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++){
            hmap.get(edges[i][0]).add(edges[i][1]);
            hmap.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                dfs(i,hmap,visited);
                res++;
            }
        }
        return res;
    }

    public void dfs(int cur, HashMap<Integer,List<Integer>> hmap, Set<Integer> visited){
        visited.add(cur);
        for(int next : hmap.get(cur)){
            if(!visited.contains(next)){
            dfs(next,hmap,visited);
            }
        }
    }
}
