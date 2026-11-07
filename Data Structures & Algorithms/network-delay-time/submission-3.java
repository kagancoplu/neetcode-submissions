class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,List<int[]>> hmap = new HashMap<>();
        for(int[] c : times){
            hmap.computeIfAbsent(c[0], x -> new ArrayList<>()).add(new int[]{c[1],c[2]});
        }
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        minheap.offer(new int[]{0,k});
        HashSet<Integer> visit = new HashSet<>();
        int res = 0;
        while(!minheap.isEmpty()){
            int[] cur = minheap.poll();
            int w1 = cur[0],n1 = cur[1];
            if(visit.contains(n1)){
                 continue;
            }
            visit.add(n1);
            res = Math.max(res, w1);
            for(int[] nb : hmap.getOrDefault(n1,new ArrayList<>())){
                int n2 = nb[0],w2 = nb[1];
                if(!visit.contains(n2)){
                    minheap.offer(new int[]{w1+  w2, n2});
                }
            }
        }
        return visit.size() == n ? res : -1;
    }
}
