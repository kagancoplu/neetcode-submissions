class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);
        int max = 0;
        for(int cur : set){
            if(!set.contains( cur - 1)){
                int length = 0;
                while(set.contains(cur + length)){
                    length++;
                }
                max = Math.max(max,length);
            }
        }
        return max;
    }
}
