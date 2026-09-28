class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int m = 0;
        int res = 0 ;
        while (l <= r){
            m = l + ((r - l) / 2);
            if((long) m * m  > x){
               r = m - 1;
               continue;
            }
            else if((long) m* m < x){
                l = m + 1;
                res = m;
                continue;
            }
            else {
                return m;
            }
        }
    return res;
    }
}