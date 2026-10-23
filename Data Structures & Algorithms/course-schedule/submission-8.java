class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int p = prerequisites.length;
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < p; i++) {
            hmap.computeIfAbsent(prerequisites[i][0], key -> new ArrayList<>())
                .add(prerequisites[i][1]);
        }
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i,visited,hmap)) return false;
        }
        return true;
    }

    public boolean dfs(int cur, Set<Integer> visited, Map<Integer, List<Integer>> hmap) {
        if (visited.contains(cur))
            return false;
        if (hmap.get(cur) == null)
            return true;
        visited.add(cur);
        for (int dep : hmap.get(cur)) {
            if (!dfs(dep, visited, hmap))
                return false;
        }
        visited.remove(cur);
        hmap.put(cur, new ArrayList<Integer>());
        return true;
    }
}
