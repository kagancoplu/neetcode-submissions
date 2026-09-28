class Solution {
    public boolean hasDuplicate(int[] nums) {
        Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
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