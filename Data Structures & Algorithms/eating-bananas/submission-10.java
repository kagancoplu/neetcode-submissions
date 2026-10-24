class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(h < piles.length) return -1;
        int left = 1,right = 0;
        for(int i : piles){
            right = Math.max(right,i);
        }
        int res = right;
        while(left <right){
            double mid = (left + right) / 2;
            int hours = 0;
            for(int p : piles){
                hours += Math.ceil(p / mid);
            }
            if(hours <= h){
                res = Math.min(res,(int)mid);
                right = (int)mid; 
            }
            else{
                left = (int)mid + 1;
            }
        }
        return res;
    }
}
