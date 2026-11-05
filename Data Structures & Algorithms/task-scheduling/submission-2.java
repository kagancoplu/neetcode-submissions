class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c : tasks){
            count[c - 'A']++;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int c : count){
            if(c > 0){
                heap.add(c);
            }
        }
        int time = 0;
        Queue<int[]> que = new LinkedList<>();
        while(!heap.isEmpty() || !que.isEmpty()){
            time++;
            if(!heap.isEmpty()){
                int cnt = heap.poll() - 1;
                if(cnt > 0){
                    que.add(new int[]{cnt,time + n});
                }
            }
            if(!que.isEmpty() && que.peek()[1] == time){
                heap.add(que.poll()[0]);
            }
        }
        return time;
    }
}