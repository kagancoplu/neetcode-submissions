class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            int[] cur = intervals[i];
            if(newInterval[1] < cur[0]){
                res.add(newInterval);
                for(int j = i; j < intervals.length; j++) res.add(intervals[j]);
                return res.toArray(new int[0][]);
            }
            else if(cur[1] < newInterval[0]){
                res.add(cur);
            }else{
                newInterval = new int[]{
                    Math.min(cur[0],newInterval[0]),
                    Math.max(cur[1],newInterval[1])
                };
            }
        }
        res.add(newInterval);
        return res.toArray(new int[0][]);
    }
}
