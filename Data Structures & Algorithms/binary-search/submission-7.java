class Solution {
    public int search(int[] nums, int target) {
        return helper(nums,target,0,nums.length - 1);
    }

    public int helper(int[] nums, int target, int start, int end){
        if(start > end) return -1;
        int half = (start + end ) / 2;
        if(nums[half] < target){
            return helper(nums,target,half + 1,end);
        }
        else if(nums[half] > target){
            return helper(nums,target,start, half - 1);
        }
        else{
            return half;
        }
    }
}
