class Solution {
     List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums,target,0,new ArrayList<>(),0);
        return res;
    }

    public void dfs(int[] nums,int target, int i, List<Integer> cur, int total){
        if(total == target){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(i >= nums.length || total > target){
            return;
        }
        cur.add(nums[i]);
        dfs(nums,target,i,cur,total + nums[i]);
        cur.remove(cur.size() - 1);
        dfs(nums,target, ++i,cur,total);
    }
}
