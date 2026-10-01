class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            if(hmap.containsKey(target - numbers[i])){
                return new int[]{hmap.get(target-numbers[i]),i + 1};
            }
            hmap.put(numbers[i],i+1);
            
        }
        return new int[]{0,0};

    }
}
