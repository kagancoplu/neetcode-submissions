class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(0,nums.length-1,nums,k);
    }

    public int quickSelect(int l , int r, int[] nums, int k){
        int pivot = nums[r];
        int p = l;
        for(int i = l; i< r;i++){
            if(nums[i] <= pivot){
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p++;
            }
        }
        int temp = nums[p];
            nums[p] = nums[r];
            nums[r] = temp;
        if(p > k){
            return quickSelect(l,p-1,nums,k);
        }
        else if(p < k){
            return quickSelect(p+1, r,nums,k);
        }
        else return nums[p];
    }
}
