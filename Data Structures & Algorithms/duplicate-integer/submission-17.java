class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer> ht = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(ht.containsKey(nums[i]) == false){
                ht.put(nums[i],1);
            }else{
                return true;
            }
        }
        return false;
    }
}