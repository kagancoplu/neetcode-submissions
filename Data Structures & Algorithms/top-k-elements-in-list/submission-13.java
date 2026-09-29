class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> count = new HashMap<>();
        List<List<Integer>> freq = new ArrayList<>();
        for(int cur : nums){
            count.put(cur, count.getOrDefault(cur,0) + 1);
        }
        for(int i = 0; i < nums.length + 1; i++){
            freq.add(new ArrayList<>());
            }
        for(int cur : count.keySet()){
            freq.get(count.get(cur)).add(cur);
        }
        int[] res = new int[k];
        int index =0;
        for(int i = freq.size()-1; i > 0; i--){
            while(!freq.get(i).isEmpty() && index < k){
                res[index++] = freq.get(i).get(freq.get(i).size() - 1);
                freq.get(i).remove(freq.get(i).size() - 1);
            }
        }
        return res;
        }
    }
