class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> res = new HashSet<Integer>();
        for (int i : nums){
            if(!res.add(i)){
                return true;
            }
        }
        return false;
    }
}