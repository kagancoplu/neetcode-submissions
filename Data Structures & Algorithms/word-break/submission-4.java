class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] arr = new boolean[s.length() +1];
        Arrays.fill(arr, false);
        arr[s.length()] = true;
        for(int i = s.length() - 1; i >= 0; i--){
            for(String cur : wordDict){
                if(i + cur.length() <= s.length() && s.substring(i,i + cur.length()).equals(cur)){
                    arr[i] = arr[i + cur.length()];
                }
                if(arr[i]) break;
            }
        }
        return arr[0];
    }
}
