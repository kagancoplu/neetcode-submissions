class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            int target = 0 - nums[i];
            while(l < r){
                if(nums[l] + nums[r] < target) l++;
                else if(nums[l] + nums[r] > target) r--;
                else{
                    res.add(new ArrayList<>(List.of(nums[i],nums[l],nums[r])));
                    l++;
                    r--;
                    while(nums[l] == nums[l-1] && l < r) l++;
                }
            }
        }
        return res;
    }
}
