class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp,-1);
        return dfs(0,dp,s);
    }

    public int dfs(int index, int[] dp, String s){
        if(index == s.length()) return 1;
        if(dp[index] != -1) return dp[index];
        if(s.charAt(index) == '0') return 0;
        int res = dfs(index +1,dp,s);
        if(index + 1 < s.length() && (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) <= '6')){
            res += dfs(index + 2,dp,s);
        }
        dp[index] = res;
        return dp[index];
    }
}
