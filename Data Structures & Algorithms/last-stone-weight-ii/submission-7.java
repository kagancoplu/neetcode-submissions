class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i  : stones){
            sum += i;
        }
        int target = (sum + 1) / 2;
        HashMap<String,Integer> dp = new HashMap<>();
        return dfs(0,0,target,sum,dp,stones);
    }

    public int dfs(int i, int total,int target, int sum, HashMap<String,Integer> dp, int[] stones){
        if(total >= target || i == stones.length){
            return Math.abs(total - (sum-total));
        }
        if(dp.containsKey(i + "," + total)){
            return dp.get(i + "," + total);
        }
        String key = i + "," + total;
        dp.put(key,Math.min(dfs(i + 1, total,target,sum,dp,stones),dfs(i+1,total + stones[i],target,sum,dp,stones)));
        return dp.get(key);
    }
}