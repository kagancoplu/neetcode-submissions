class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pque = new PriorityQueue<>();
        for(int cur : nums){
            pque.add(cur);
            if(pque.size() > k){
                pque.poll();
            }
        }
        return pque.peek();
    }
}
