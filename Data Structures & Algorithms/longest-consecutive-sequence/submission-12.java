class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hset = new HashSet<>();
        for(int cur : nums){
            hset.add(cur);
        }
        int longest = 0;
        for(int cur : nums){
            if(!hset.contains(cur - 1)){
                int length = 0;
                while(hset.contains(cur + length)){
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;
    }
}
