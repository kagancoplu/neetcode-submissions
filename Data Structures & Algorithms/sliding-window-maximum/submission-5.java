class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int l = 0;
        int r = k - 1;
        int curmax = nums[0];
        int curpos = 0;
        for(int i = 0; i < k; i++){
            curmax = Math.max(curmax,nums[i]);
        }
        res[curpos++] = curmax;
        l++;
        r++;
        while(r < nums.length){
            if(curmax == nums[l - 1]){
                curmax = nums[l];
                for(int i = l + 1; i <= r; i++){
                    curmax = Math.max(curmax,nums[i]);
                }
            }
            if( r < nums.length && curmax < nums[r]){
                curmax = nums[r];
            }
            res[curpos++] = curmax;
            l++;
            r++;
        }
        return res;
    }
}
