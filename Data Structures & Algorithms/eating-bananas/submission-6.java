class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(h < piles.length) return -1;
        int max = 0;
        for(int i : piles){
            max = Math.max(max,i);
        }
        int left = 1,right = max;
        int res = max;
        while(left <= right){
            double mid = (left + right) / 2;
            int hours = 0;
            for(int p : piles){
                hours += Math.ceil(p / mid);
            }
            if(hours <= h){
                res = Math.min(res,(int)mid);
                right = (int)mid - 1; 
            }
            else{
                left = (int)mid + 1;
            }
        }
        return res;
    }
}
