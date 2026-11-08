class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }
        for(int n : nums){
            count.put(n,1 + count.getOrDefault(n,0));
        }
        for(Map.Entry<Integer, Integer> e : count.entrySet()){
            freq[e.getValue()].add(e.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = freq.length - 1; i >=0; i--){
            for(int l : freq[i]){
                res[index++] = l;
                if(index == k){
                    return res;
                }
        }
    }
            return res;

}
}
