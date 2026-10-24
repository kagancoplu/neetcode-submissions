class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n - 1 != edges.length) return false;
        HashMap<Integer,List<Integer>> hmap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; i++){
            hmap.put(i, new ArrayList<Integer>());
        }
        for(int i  =0; i < edges.length; i++){
            hmap.get(edges[i][0]).add(edges[i][1]);
            hmap.get(edges[i][1]).add(edges[i][0]);
        }
        dfs(0,-1,hmap,visited);
        return visited.size() == n;
        }

        public boolean dfs(int cur, int prev, HashMap<Integer,List<Integer>> hmap, Set<Integer> visited){
            if(visited.contains(cur)) return false;
            visited.add(cur);
            for(int i : hmap.get(cur)){
                if(i == prev){
                    continue;
                }
                if(!dfs(i,cur,hmap,visited)) return false;
            }
            return true;

        }
}
