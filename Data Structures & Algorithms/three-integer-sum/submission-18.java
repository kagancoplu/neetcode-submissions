class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] copy = nums.clone();
        Arrays.sort(copy);
        for(int i = 0; i < nums.length; i++){
            int a = copy[i];
            if(i > 0 && a == copy[i - 1]) continue;
            int l = i + 1;
            int r = copy.length - 1;
            while(l < r){
                int threeSum = a + copy[l] + copy[r];
                if(threeSum > 0){
                    r--;
                }else if(threeSum < 0){
                    l++;
                }
                else{
                    res.add(new ArrayList<>(List.of(a,copy[l],copy[r])));
                    l++;
                    while(copy[l] == copy[l - 1] && l < r)l++;
                }
            }
        }
        return res;
    }
}
