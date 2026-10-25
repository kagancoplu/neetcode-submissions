class Solution {
    public int[][] kClosest(int[][] points, int k){
        PriorityQueue<double[]> pque = new PriorityQueue<>((a,b) ->Double.compare(a[0],b[0]));
        for(int i = 0; i < points.length; i++){
           pque.add(new double[]{Math.pow(points[i][0],2) + Math.pow(points[i][1],2),points[i][0],points[i][1]});
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            double[] cur = pque.poll();
            res[i] = new int[]{(int)cur[1],(int)cur[2]};
        }
        return res;
    }
}
