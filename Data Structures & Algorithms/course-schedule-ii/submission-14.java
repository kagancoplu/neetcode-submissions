class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> hmap = new HashMap<>();
        Set<Integer> visited = new HashSet<Integer>();
        List<Integer> output = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            hmap.put(i,new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length;i++){
            hmap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] res = new int[numCourses];
        Set<Integer> cycle = new HashSet<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i,cycle,visited,prerequisites,hmap,output)) return new int[0];
        }
        int[] arr = new int[output.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = output.get(i);
        }
        return arr;
    }

    public boolean dfs(int cur, Set<Integer> cycle, Set<Integer> visited, int[][] p, Map<Integer,List<Integer>> hmap,List<Integer> output){
        if(cycle.contains(cur)) return false;
        if(visited.contains(cur)) return true;
        cycle.add(cur);
        for(int pre : hmap.get(cur)){
            if(!dfs(pre,cycle,visited,p,hmap,output)) return false;
        }
        cycle.remove(cur);
        visited.add(cur);
        output.add(cur);
        return true;
    }
}
