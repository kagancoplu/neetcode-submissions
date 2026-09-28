class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int m = 0;
        int res = 0 ;
        long sq = 0;
        while (l <= r){
            m = l + ((r - l) / 2);
            sq = (long) m*m;
            if(sq  > x){
               r = m - 1;
               continue;
            }
            else if(sq < x){
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