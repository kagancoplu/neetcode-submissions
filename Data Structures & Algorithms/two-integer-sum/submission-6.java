class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hmap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length;i++){
            int rest = target - nums[i];
            if(hmap.containsKey(rest)){
                return new int[]{hmap.get(rest),i};
            }
            hmap.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}
