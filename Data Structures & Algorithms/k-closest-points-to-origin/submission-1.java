class Solution {
    public int[][] kClosest(int[][] points, int k){
        PriorityQueue<int[]> pque = new PriorityQueue<>((a,b) -> (a[0] *a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
        for(int i = 0; i < points.length; i++){
           pque.add(points[i]);
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            int[] cur = pque.poll();
            res[i] = cur;
        }
        return res;
    }
}
