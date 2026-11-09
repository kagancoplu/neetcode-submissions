/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] starts = new int [intervals.size()];
        int[] ends= new int [intervals.size()];
        for(int i = 0; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            starts[i] = cur.start;
            ends[i] = cur.end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int res =0;
        int count = 0;
        int s= 0;
        int e = 0;
        while(s < intervals.size()){
            if(starts[s] < ends[e]){
                s++;
                count++;
                res = Math.max(res, count);
            }
            else{
                e++;
                count--;
                res = Math.max(res,count);
            }
        }
        return res;
    }
}
